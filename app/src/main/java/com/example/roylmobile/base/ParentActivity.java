package com.example.roylmobile.base;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.roylmobile.dialogs.CustomProgressDialog;
import com.example.roylmobile.utils.GlobalPreferences;
import com.example.roylmobile.utils.Util;
import com.example.roylmobile.widgets.Toaster;

import butterknife.ButterKnife;

public abstract class ParentActivity extends AppCompatActivity implements View.OnClickListener {

    protected AppCompatActivity activity;
    protected GlobalPreferences globalPreferences;
    protected Toaster toaster;
    private int menuId;
    protected CustomProgressDialog dialog;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (isFullScreen()) {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        if (hideInputeType()) {
            hideInputtype();
        }
        setContentView(getLayoutResource());
        activity = this;
        globalPreferences = new GlobalPreferences(this);
        toaster = new Toaster(this);
        dialog = new CustomProgressDialog(this);
        ButterKnife.bind(this);

        // initialize item
        init();

    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        // call superclass to save any view hierarchy
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }


    protected abstract int getLayoutResource();

    protected abstract boolean isFullScreen();

    protected abstract void init();

    protected abstract boolean isEnableBack();


    protected abstract boolean hideInputeType();


    public void createOptionsMenu(int menuId) {
        this.menuId = menuId;
        invalidateOptionsMenu();
    }

    /**
     * function is used to create a menu
     */
    public void removeOptionsMenu() {
        menuId = 0;
        invalidateOptionsMenu();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (menuId != 0) {
            getMenuInflater().inflate(menuId, menu);
        }

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    /**
     * finish the connection to database
     */
    @Override
    protected void onStop() {
        super.onStop();
    }


    public void hideInputtype() {
        if (getCurrentFocus() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }

    }

    // to override typekit in all activities we use


    public void showProgressDialog(){

        Util.showDialog(dialog,this);

    }
    public void dismissProgressDialog() {

        Util.dismissDialog(dialog,this);
    }
    @Override
    public void onDestroy(){
        dismissProgressDialog();
        super.onDestroy();
    }
}
