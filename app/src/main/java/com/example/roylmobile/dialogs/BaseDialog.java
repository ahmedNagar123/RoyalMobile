package com.example.roylmobile.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.example.roylmobile.utils.GlobalPreferences;
import com.example.roylmobile.widgets.Toaster;

import butterknife.ButterKnife;

public abstract class BaseDialog extends Dialog implements View.OnClickListener {

    protected GlobalPreferences globalPreferences;
    protected Toaster toaster;
    protected Context context;
    protected CustomProgressDialog dialog;
    public BaseDialog(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(getViewId());
        // we set this one if we need to enable our dialog to fill all the width and hight of the screen .
        if (isFullWidth())
            getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        else
            getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        getWindow().setGravity(Gravity.CENTER);
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        //  getWindow().setTransitionBackgroundFadeDuration(5000);
        if (isCancelable()) {
            setCancelable(true);
            setCanceledOnTouchOutside(true);
        } else {
            setCancelable(false);
            setCanceledOnTouchOutside(false);
        }
        globalPreferences = new GlobalPreferences(context);
        toaster = new Toaster(context);
        dialog = new CustomProgressDialog(context);
        ButterKnife.bind(this);
        init(savedInstanceState);
    }

    protected abstract int getViewId();

    protected abstract boolean isFullWidth();

    protected abstract boolean isCancelable();

    protected abstract void init(Bundle savedInstanceState);

}
