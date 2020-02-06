package com.example.roylmobile.components;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

public class DarkenedButton extends Button {public DarkenedButton(Context context) {
    super(context);
    setOnTouchListener(new DarkerOnTouchListener(this));
}

    public DarkenedButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnTouchListener(new DarkerOnTouchListener(this));
    }

    public DarkenedButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOnTouchListener(new DarkerOnTouchListener(this));
    }
}
