package com.example.roylmobile.search;

import androidx.appcompat.widget.AppCompatImageButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.roylmobile.Home.HomePresenter;
import com.example.roylmobile.Home.HomeView;
import com.example.roylmobile.Model.Phono;
import com.example.roylmobile.R;
import com.example.roylmobile.base.ParentActivity;
import com.example.roylmobile.utils.Constants;

import java.util.List;

import butterknife.BindView;

public class SearchActivity extends ParentActivity implements HomeView {


    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.aciBtnBack)
    AppCompatImageButton aciBtnBack;

    private SearchAdapter adapter;
    private String brand;
    private String token;
    private HomePresenter homePresenter;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_search;
    }

    @Override
    protected boolean isFullScreen() {
        return false;
    }

    @Override
    protected void init() {

        brand = getIntent().getStringExtra("brand");
        Log.i("brand",brand);

        adapter=new SearchAdapter(getApplicationContext());
        recyclerView.setAdapter(adapter);

        recyclerView.setNestedScrollingEnabled(false);

        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        homePresenter = new HomePresenter(this);
        token= Constants.Token;
        homePresenter.fetchPhono(brand,token);
        aciBtnBack.setOnClickListener(this);


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
            case R.id.aciBtnBack:
                finish();
                break;

        }

    }

    @Override
    public void fetchPhono(String brand, String token) {

    }

    @Override
    public void view(List<Phono> phono) {

        List<Phono> phonoList=  phono;
        Log.i("brand",phonoList.toString());
        adapter.setMoviesData(phonoList);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void errorConnection() {
        Toast.makeText(activity, "Faild .... please check your Internet connection", Toast.LENGTH_SHORT).show();
        // Internet connection faild Layout
        //   startActivity(new Intent(activity,));
    }

    @Override
    public void errorFalid() {
        Toast.makeText(activity, "Faild .... please Try Again", Toast.LENGTH_SHORT).show();

    }
}
