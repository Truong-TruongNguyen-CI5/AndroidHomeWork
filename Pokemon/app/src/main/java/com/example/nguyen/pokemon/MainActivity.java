package com.example.nguyen.pokemon;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = MainActivity.class.toString() ;
    @BindView(R.id.im_play) ImageView imPlay;
    @BindView(R.id.im_setting) ImageView imSetting;
    float width;
    float height;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupUI();
        addListeners();
    }

    private void addListeners() {
        imPlay.setOnClickListener(this);
        imSetting.setOnClickListener(this);
    }

    public void onWindowFocusChanged(boolean hasFocus){
        super.onWindowFocusChanged(hasFocus);

        width =  findViewById(R.id.rl_1).getWidth();
        height = findViewById(R.id.rl_1).getHeight();

        imPlay.setX(width/2 - imPlay.getWidth()/2);
        imPlay.setY((height*5)/8  - imPlay.getHeight()/2 );
        System.out.println(String.format("%s %s", imPlay.getX(), imPlay.getY()));
    }

    private void setupUI() {
        DisplayMetrics metrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        width = metrics.widthPixels;
        height = metrics.heightPixels;
        imPlay.getLayoutParams().width = (int) (width* 0.4);
        imPlay.getLayoutParams().height = (int) (width*0.4);
        imPlay.requestLayout();
    }

    @Override
    public void onClick(View v) {
        if((ImageView) v == imSetting){
            this.changeFragment(new SettingFragment(), true,null);
        }
        if((ImageView) v == imPlay){
            this.changeFragment(new PlayFragment(), true, null);
        }
    }

    public void changeFragment(Fragment fragment, boolean addToBackstack, String tag){
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_main, fragment);
        if(addToBackstack){
            fragmentTransaction.addToBackStack(tag);
        }
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
