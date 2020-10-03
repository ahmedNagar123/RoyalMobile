package com.example.roylmobile.Home;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import com.example.roylmobile.R;
import com.example.roylmobile.databinding.ActivityHomeBinding;
import com.example.roylmobile.search.SearchActivity;

public class HomeActivity extends AppCompatActivity {
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityHomeBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_home);

//       set Adapter spinner
        adapter = ArrayAdapter.createFromResource(this, R.array.demo_Brand, R.layout.spinner_item);
        adapter.setDropDownViewResource(R.layout.spinner_item);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown);
        binding.spBrand.setAdapter(adapter);
        binding.dBtnSearch.setOnClickListener(v -> {
            Intent intent=new Intent(HomeActivity.this, SearchActivity.class);

            intent.putExtra("brand",binding.spBrand.getSelectedItem().toString());
            intent.putExtra("etFrom",binding.etFrom.getText());
            intent.putExtra("etTo",binding.etTo.getText());
            startActivity(intent);
        });


    }
}


