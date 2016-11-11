package com.example.nguyen.animationdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import layout.Fragment1;
import layout.Fragment2;

public class AnimationActivity extends AppCompatActivity {
    private Button btAnimate;
    private boolean check = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        btAnimate = (Button) findViewById(R.id.bt_animate);
        addListeners();
    }
    private void addListeners() {
        btAnimate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check == false) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .setCustomAnimations(R.anim.enter, R.anim.exit)
                            .replace(R.id.fl_container, new Fragment1())
                            .commit();
                    check = true;
                }
                else {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .setCustomAnimations(R.anim.enter, R.anim.exit)
                            .replace(R.id.fl_container, new Fragment2())
                            .commit();
                    check = false;
                }
            }
        });
    }
}
