package com.example.nguyen.homework_ss6_2;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import butterknife.*;
public class MainActivity extends AppCompatActivity {
    @BindView(R.id.im_avatar) ImageView imAvatar;
    @BindView(R.id.im_v1) ImageView imV1;
    @BindView(R.id.im_v2) ImageView imV2;
    @BindView(R.id.im_v3) ImageView imV3;
    @BindView(R.id.im_v4) ImageView imV4;
    @BindView(R.id.im_v5) ImageView imV5;
    @BindView(R.id.im_v6) ImageView imV6;
    @BindView(R.id.im_v7) ImageView imV7;
    @BindView(R.id.im_v8) ImageView imV8;
    @BindView(R.id.im_v9) ImageView imV9;
    @BindView(R.id.im_v10) ImageView imV10;
    @BindView(R.id.im_v11) ImageView imV11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupUI();
    }

    private void setupUI() {
        imV1.setImageResource(R.drawable.bitmap1);
        imV2.setImageResource(R.drawable.bitmap2);
        imV3.setImageResource(R.drawable.bitmap3);
        imV4.setImageResource(R.drawable.bitmap4);
        imV5.setImageResource(R.drawable.bitmap11);
        imV6.setImageResource(R.drawable.bitmap6);
        imV7.setImageResource(R.drawable.bitmap7);
        imV8.setImageResource(R.drawable.bitmap8);
        imV9.setImageResource(R.drawable.bitmap1);
        imV10.setImageResource(R.drawable.bitmap4);
        imV11.setImageResource(R.drawable.bitmap11);
        imAvatar.setImageResource(R.drawable.oval_avatar);
    }
}
