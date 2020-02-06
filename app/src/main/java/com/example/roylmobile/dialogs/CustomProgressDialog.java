package com.example.roylmobile.dialogs;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.example.roylmobile.R;

public class CustomProgressDialog extends BaseDialog {
    public CustomProgressDialog(Context context) {
        super(context);
    }

    @Override
    protected int getViewId() {
        return R.layout.progess_dialog;
    }

    @Override
    protected boolean isFullWidth() {
        return false;
    }

    @Override
    protected boolean isCancelable() {
        return false;
    }

    @Override
    protected void init(Bundle savedInstanceState) {

    }

    @Override
    public void onClick(View view) {

    }
}
