package com.example.nguyen.turn1;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Nguyen on 10/3/2016.
 */

public class TextViewValue extends TextView {
    public TextViewValue(Context context) {
        super(context);
        initForm(context, null);
    }

    public TextViewValue(Context context, AttributeSet attrs) {
        super(context, attrs);
        initForm(context, attrs);
    }

    public TextViewValue(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initForm(context, attrs);
    }
    private void initForm(Context context, AttributeSet attrs){
        if(attrs != null){
            TypedArray typedArray =  context.obtainStyledAttributes(attrs, R.styleable.TextViewValue);
            int value = typedArray.getInt(R.styleable.TextViewValue_value, -1);
            if(value != -1)
                this.setText(String.valueOf(value));
        }
    }
}
