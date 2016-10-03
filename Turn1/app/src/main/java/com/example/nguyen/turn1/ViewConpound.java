package com.example.nguyen.turn1;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.*;

/**
 * Created by Nguyen on 10/2/2016.
 */

public class ViewConpound extends RelativeLayout {
    @BindView(R.id.edt_value)
    TextViewValue edtValue;
    @BindView(R.id.im_decrease)
    ImageView imDecrease;
    @BindView(R.id.im_increase)
    ImageView imIncrease;
    @BindView(R.id.tv_label)
    TextViewLabel tvLabel;
    private int value;
    public ViewConpound(Context context) {
        super(context);
        initFormontext(context,null);
    }

    public ViewConpound(Context context, AttributeSet attrs) {
        super(context, attrs);
        initFormontext(context, attrs);
    }

    public ViewConpound(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initFormontext(context, attrs);
    }

    private void initFormontext(Context context, AttributeSet attrs){
        View rootView = inflate(context, R.layout.view_compound, this);
        ButterKnife.bind(this, rootView);
//        if(attrs != null){
//            TypedArray typedArray_value = context.obtainStyledAttributes(R.styleable.TextViewValue);
//            int val = typedArray_value.getInt(R.styleable.TextViewValue_value, -1);
//            edtValue.setText(String.valueOf(val));
//
//            TypedArray typedArray_label = context.obtainStyledAttributes(R.styleable.TextViewValue);
//            String label = typedArray_label.getString(R.styleable.TextViewLabel_label);
//            tvLabel.setText(label);
//
//            typedArray_label.recycle();
//            typedArray_value.recycle();
//        }
//        edtValue.setText(String.valueOf(value));
        imDecrease.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDecrease();
            }
        });
        imIncrease.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                updateIncrease();
            }
        });
    }
    private void updateDecrease(){
        value --;
        edtValue.setText(String.valueOf(value));
    }
    private void updateIncrease(){
        value ++;
        edtValue.setText(String.valueOf(value));
    }
}
