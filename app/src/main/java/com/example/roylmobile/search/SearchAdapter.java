package com.example.roylmobile.search;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roylmobile.DetailsActivity;
import com.example.roylmobile.Model.Phono;
import com.example.roylmobile.R;
import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder>   {

    private Context context;

    private LayoutInflater inflater;
    private List<Phono> phonoList;
    private Phono phono;


    public SearchAdapter(Context context){
        this.context=context;
        inflater= (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root=inflater.inflate(R.layout.list_item_search,parent,false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        phono = phonoList.get(position);
        if (phono.getDeviceName()==null){
            holder.tvPhoneName.setText("Not Avaliable");
        }else {
            holder.tvPhoneName.setText(phono.getDeviceName());}
        if (phono.getTriple()==null && phono.getdual_()==null && phono.getquad_()==null&& phono.getprimary_()==null ){
            holder.tvcameraResolution.setText("CameraResolution:Not Avaliable");
        }else {
            if (phono.getTriple()!=null)
                holder.tvcameraResolution.setText("CameraResolution: "+phono.getTriple());
            if (phono.getdual_()!=null)
                holder.tvcameraResolution.setText("CameraResolution: "+phono.getdual_());
            if (phono.getquad_()!=null)
                holder.tvcameraResolution.setText("CameraResolution: "+phono.getquad_());
            if (phono.getquad_()!=null)
                holder.tvcameraResolution.setText("CameraResolution: "+phono.getprimary_());

        }
        if (phono.getInternal()==null){
            holder.tvRam.setText("Ram: Not Avaliable");
        }else {
            holder.tvRam.setText("Ram: " +phono.getInternal());}
        if (phono.getTechnology()==null){
            holder.tvNetworktechnology.setText("Network technology: Not Avaliable");
        }else {
            holder.tvNetworktechnology.setText("Network technology: " +phono.getTechnology());}
        if (phono.getSingle()==null){
            holder.tvSecondCamera.setText("Second Camera: Not Avaliable");
        }else {
            holder.tvSecondCamera.setText("Second Camera: " +phono.getSingle());}
        holder.btnSearch.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailsActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            Log.e("phone before", new Gson().toJson(phonoList.get(position)));
            intent.putExtra("mobile", phonoList.get(position));
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return phonoList!=null?phonoList.size():0;
    }

    public void setMoviesData(List<Phono> phonoList) { this.phonoList=phonoList; }



    class ViewHolder extends RecyclerView.ViewHolder{


        @BindView(R.id.ivPhone)
        ImageView cIvFamily;

        @BindView(R.id.tvPhoneName)
        TextView tvPhoneName;
        @BindView(R.id.tvcameraResolution)
        TextView tvcameraResolution;
        @BindView(R.id.tvRam)
        TextView tvRam;
        @BindView(R.id.tvSecondCamera)
        TextView tvSecondCamera;
        @BindView(R.id.tvNetworktechnology)
        TextView tvNetworktechnology;

        @BindView(R.id.btnSearch)
        Button btnSearch;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);


        }


    }
}
