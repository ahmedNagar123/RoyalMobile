package com.example.roylmobile.search;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

import com.example.roylmobile.R;
import com.example.roylmobile.databinding.ActivitySearchBinding;
import com.example.roylmobile.utils.Constants;

public class SearchActivity extends AppCompatActivity {

    SearchViewModel searchViewModel;
    private SearchAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySearchBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_search);
        String brand = getIntent().getStringExtra("brand");
//        setViewModel
        searchViewModel= new ViewModelProvider(this).get(SearchViewModel.class);
        searchViewModel.getPhone(brand,Constants.Token);
        //        set Adapter
        adapter=new SearchAdapter(getApplicationContext());
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setNestedScrollingEnabled(false);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        binding.toolbar.aciBtnBack.setOnClickListener(v -> finish());
        searchViewModel.phoneMutableLiveData.observe(this, phones -> adapter.setPhoneData(phones));
    }
}
