package com.example.nguyen.turn1;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Nguyen on 10/3/2016.
 */

public class TextViewLabel extends TextView {
    public TextViewLabel(Context context) {
        super(context);
        initForm(context, null);
    }

    public TextViewLabel(Context context, AttributeSet attrs) {
        super(context, attrs);
        initForm(context, attrs);
    }

    public TextViewLabel(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initForm(context, attrs);
    }
    private void initForm(Context context, AttributeSet attrs){
        if(attrs != null){
            TypedArray typedArray =  context.obtainStyledAttributes(attrs, R.styleable.TextViewLabel);
            String label = typedArray.getString(R.styleable.TextViewLabel_label);
            this.setText(label);
        }
    }
}
