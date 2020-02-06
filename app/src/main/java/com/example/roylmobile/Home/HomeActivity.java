package com.example.roylmobile.Home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.roylmobile.R;
import com.example.roylmobile.base.ParentActivity;
import com.example.roylmobile.components.DarkenedButton;
import com.example.roylmobile.search.SearchActivity;

import butterknife.BindView;

public class HomeActivity extends ParentActivity implements  AdapterView.OnItemSelectedListener {

    @BindView(R.id.spBrand)
    Spinner spinner;

    @BindView(R.id.etFrom)
    EditText etFrom;
    @BindView(R.id.etTo)
    EditText etTo;

    @BindView(R.id.dBtnSearch)
    DarkenedButton dBtnSearch;

    private ArrayAdapter adapter;
    private String Brand;
    private String etFromtxt,etTotxt;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_home;
    }

    @Override
    protected boolean isFullScreen() {
        return false;
    }

    @Override
    protected void init() {

        adapter = ArrayAdapter.createFromResource(this, R.array.demo_Brand, R.layout.spinner_item);
        adapter.setDropDownViewResource(R.layout.spinner_item);
        spinner.setAdapter(adapter);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown);

        dBtnSearch.setOnClickListener(this);
        spinner.setOnItemSelectedListener(this);

        etFromtxt = etFrom.getText().toString();
        etTotxt = etTo.getText().toString();
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
        switch (v.getId()){

            case R.id.dBtnSearch:
                Intent intent=new Intent(HomeActivity.this, SearchActivity.class);
                intent.putExtra("brand",Brand);
                intent.putExtra("etFromtxt",etFromtxt);
                intent.putExtra("etTotxt",etTotxt);
                startActivity(intent);
                break;

        }

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Brand = spinner.getSelectedItem().toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}