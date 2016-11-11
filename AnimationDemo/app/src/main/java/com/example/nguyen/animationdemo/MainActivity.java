package com.example.nguyen.animationdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

import layout.Fragment1;

public class MainActivity extends AppCompatActivity {
    private static final String TAG =MainActivity.class.toString();
    private View vItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vItem = findViewById(R.id.v_item);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater()
                .inflate(R.menu.actionbar_menu, menu);
        menu.findItem(R.id.mni_animate).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Log.d(TAG, "onItemClick");
                //translate();
                //translateByXML();
                //rotate();
                //rotateByXML();
                //scale();
                //alpha();
                fillHeadParent();
                return false;
            }
        });
        return true;

    }
    private void translate(){
        //1 Create Animation
        TranslateAnimation translateAnimation = new TranslateAnimation(0, 500
                , 0, 500);
        translateAnimation.setDuration(200);

        translateAnimation.setInterpolator(new LinearInterpolator());
        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                rotate();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        vItem.startAnimation(translateAnimation);
        //2 Animate
    }



    private void translateByXML(){
        //1 Load animation fom XML
        Animation animation =  AnimationUtils.loadAnimation(this, R.anim.move_to_right);
        vItem.startAnimation(animation);
    }

    private void fillHeadParent(){
        TranslateAnimation translateAnimation = new TranslateAnimation(
                0, 0,
                0, -vItem.getTop()
        );
        translateAnimation.setDuration(1000);
        translateAnimation.setFillAfter(true);


        Animation scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.fill_head_parent);

        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(translateAnimation);
        animationSet.setFillAfter(true);
        animationSet.setDuration(1000);


        vItem.startAnimation(animationSet);
    }

    private void rotate(){
        RotateAnimation rotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF , 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(2000);
        rotateAnimation.setRepeatCount(2);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        vItem.startAnimation(rotateAnimation);
    }

    private void rotateByXML(){
        Animation rotateAanimation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        vItem.startAnimation(rotateAanimation);
    }

    private void scale(){
        ScaleAnimation scaleAnimation = new ScaleAnimation(1,2,1,2,
                Animation.RELATIVE_TO_SELF,0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(1000);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setInterpolator(new LinearInterpolator());
        vItem.startAnimation(scaleAnimation);
    }
    private void alpha(){
        AlphaAnimation alphaAnimation = new AlphaAnimation(1,0.1f);
        alphaAnimation.setDuration(1000);
        alphaAnimation.setRepeatCount(2);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        vItem.startAnimation(alphaAnimation);

    }

}
