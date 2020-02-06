package com.example.roylmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.example.roylmobile.Home.HomeActivity;
import com.example.roylmobile.Home.HomeView;
import com.example.roylmobile.base.ParentActivity;

public class SplashActivity extends ParentActivity {

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_splash;
    }

    @Override
    protected boolean isFullScreen() {
        return false;
    }

    @Override
    protected void init() {
        new Handler().postDelayed(() -> {
            startActivity(new Intent(SplashActivity.this, HomeActivity.class));
            finish();
        },3000);

    }

    @Override
    protected boolean isEnableBack() {
        return false;
    }

    @Override
    protected boolean hideInputeType() {
        return false;
    }

    @Override
    public void onClick(View v) {

    }
}
