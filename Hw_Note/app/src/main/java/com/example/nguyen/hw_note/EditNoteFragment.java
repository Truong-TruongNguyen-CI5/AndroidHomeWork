package com.example.nguyen.hw_note;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class EditNoteFragment extends Fragment {
    @BindView(R.id.edt_titlee)
    EditText edtTitle;
    @BindView(R.id.edt_content)
    EditText edtContent;
    @BindView(R.id.edt_time)
    EditText edtTime;
    @BindView(R.id.bt_save)
    Button btSave;

    public static int position;

    public EditNoteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_edit_note, container, false);
        ButterKnife.bind(this, view);
        if(0<= position && position < ItemNote.itemNoteList.size())
        updateNote();
        addlisteners();
        return view;
    }

    private void addlisteners() {
        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position != NoteViewHolder.getNoteList().size()) {
                    NoteViewHolder.getNoteList().get(position).setContent(edtContent.getText().toString());
                    NoteViewHolder.getNoteList().get(position).setTime_created(edtTime.getText().toString());
                    NoteViewHolder.getNoteList().get(position).setTitle(edtTitle.getText().toString());
                    MainActivity mainActivity = (MainActivity) getActivity();
                    mainActivity.notifyDataSetChanged();

                    //DbHelper.getInstance().update(NoteViewHolder.getNoteList().get(position));
                }
                else {

                    ItemNote itemNote = new ItemNote(edtTitle.getText().toString());
                    ItemNote.itemNoteList.add(itemNote);
                    MainActivity mainActivity = (MainActivity) getActivity();
                    mainActivity.notifyDataSetChanged();
                    Note newNote = new Note(edtTitle.getText().toString(),
                            edtContent.getText().toString(),
                            edtTime.getText().toString());
                    NoteViewHolder.getNoteList().add(newNote);

                    //DbHelper.getInstance().insert(newNote);
                }
            }
        });
    }

    private void updateNote() {
        edtTitle.setText(NoteViewHolder.getNoteList().get(position).getTitle());
        edtContent.setText(NoteViewHolder.getNoteList().get(position).getContent());
        edtTime.setText(NoteViewHolder.getNoteList().get(position).getTime_created());
    }

}
