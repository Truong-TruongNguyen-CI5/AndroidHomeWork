package com.example.nguyen.turn1_105;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.AndroidCharacter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import layout.AFragment;
import layout.CFragment;
import layout.DFragment;
import layout.EFragment;
import layout.NewPayment;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.lv_Number)
    ListView lvNumber;
    private static final String ARRAY [] = new String[]{
        "07.02","08.02", "08.02", "09.02", "10.02"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getSupportActionBar().hide();
        setupUI();
        addListenners();
    }

    private void addListenners() {
        lvNumber.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:{
                        openFragment(new AFragment(), true);
                        break;
                    }
                    case 1:{
                        openFragment(new NewPayment(), true);
                        break;
                    }
                    case 2:{
                        openFragment(new CFragment(), true);
                        break;
                    }
                    case 3:{
                        openFragment(new DFragment(), true);
                        break;
                    }
                    case 4:{
                        openFragment(new EFragment(), true);
                        break;
                    }
                }
            }
        });
    }

    public void openFragment(Fragment fragment, boolean addToBackStack){
        if(addToBackStack)
            getSupportFragmentManager().beginTransaction().replace(R.id.activity_main, fragment).addToBackStack(null).commit();
        else getSupportFragmentManager().beginTransaction().replace(R.id.activity_main, fragment).commit();
    }

    private void setupUI() {
        lvNumber.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Arrays.asList(ARRAY)));
    }
}
