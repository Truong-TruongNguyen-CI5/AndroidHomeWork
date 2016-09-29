package com.example.nguyen.lab7;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NightDress extends AppCompatActivity {
    @BindView(R.id.bt_add)
    Button btAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_night_dress);
        ButterKnife.bind(this);
        setupUI();
        addListenners();
    }

    private void addListenners() {
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                SelectColorFragment selectColorFragment = new SelectColorFragment();
                selectColorFragment.show(fragmentManager, "SelectColorFragment");
            }
        });
    }

    private void setupUI() {
    }

}
