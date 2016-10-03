package com.example.nguyen.turn5;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import butterknife.BindColor;
import butterknife.ButterKnife;

/**
 * Created by Nguyen on 10/3/2016.
 */

public class CustomCircle extends View {
    @BindColor(R.color.colorAccent) int red;
    @BindColor(R.color.colorPrimary) int blue;
    Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
    public CustomCircle(Context context) {
        super(context);
        ButterKnife.bind(this);
    }

    public CustomCircle(Context context, AttributeSet attrs) {
        super(context, attrs);
        ButterKnife.bind(this);
    }

    public CustomCircle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        ButterKnife.bind(this);
    }

//@Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        float heightSize =  (getWidth() *4)/3;
//        heightMeasureSpec = MeasureSpec.makeMeasureSpec((int)heightSize, MeasureSpec.EXACTLY);
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        p.setColor(red);
        canvas.drawCircle((float) (getWidth() * 0.3), getHeight()/2, getHeight()/2, p);
        p.setColor(blue);
        canvas.drawCircle((float) (getWidth() * 0.7), getHeight()/2, getHeight()/2, p);
    }
}
