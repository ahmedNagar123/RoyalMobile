package com.example.roylmobile.components;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

public class DarkenedImageButton extends ImageButton {
    public DarkenedImageButton(Context context) {
        super(context);
        setOnTouchListener(new DarkerOnTouchListener(this));
    }

    public DarkenedImageButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnTouchListener(new DarkerOnTouchListener(this));
    }

    public DarkenedImageButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOnTouchListener(new DarkerOnTouchListener(this));
    }
}
