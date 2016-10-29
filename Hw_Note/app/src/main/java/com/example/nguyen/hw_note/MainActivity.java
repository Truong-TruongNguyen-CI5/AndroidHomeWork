package com.example.nguyen.hw_note;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.rcv_note)
    RecyclerView rcvNote;
    @BindView(R.id.bt_add)
    Button btAdd;

    public static ItemNoteAdapter itemNoteAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DbHelper.getInstance().init(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupUI();
        addListeners();
    }

    public void notifyDataSetChanged(){
        itemNoteAdapter.notifyDataSetChanged();
    }

    private void addListeners() {
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditNoteFragment.position = ItemNote.itemNoteList.size();
                changeFragment(new EditNoteFragment(), true);
            }
        });
        rcvNote.addOnItemTouchListener(new ItemClickListener(this, rcvNote, new ItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                changeFragment(new EditNoteFragment(), true);
                EditNoteFragment.position = position;
            }

            @Override
            public void onLongItemClick(View view, int position) {
                ItemNote.itemNoteList.remove(position);
                notifyDataSetChanged();

                //DbHelper.getInstance().delete(NoteViewHolder.getNoteList().get(position));
            }
        }));
    }

    public Note getNote(int position){
        return NoteViewHolder.getNoteList().get(position);
    }

    private void setupUI() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvNote.setLayoutManager(linearLayoutManager);

        itemNoteAdapter = new ItemNoteAdapter();
        rcvNote.setAdapter(itemNoteAdapter);

    }

    private void changeFragment(Fragment fragment, Boolean addToBackStack) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activity_main, fragment);
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }
}
