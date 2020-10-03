package com.example.roylmobile.search;

import android.annotation.SuppressLint;
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
import com.example.roylmobile.Model.Phone;
import com.example.roylmobile.R;
import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder>   {

    private Context context;

    private LayoutInflater inflater;
    private List<Phone> phoneList;
    private Phone phone;


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

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        phone = phoneList.get(position);
        if (phone.getDeviceName()==null){
            holder.tvPhoneName.setText("Not Available");
        }else {
            holder.tvPhoneName.setText(phone.getDeviceName());}
        if (phone.getTriple()==null && phone.getdual_()==null && phone.getquad_()==null&& phone.getprimary_()==null ){
            holder.tvCameraResolution.setText("CameraResolution:Not Available");
        }else {
            if (phone.getTriple()!=null)
                holder.tvCameraResolution.setText("CameraResolution: "+ phone.getTriple());
            if (phone.getdual_()!=null)
                holder.tvCameraResolution.setText("CameraResolution: "+ phone.getdual_());
            if (phone.getquad_()!=null)
                holder.tvCameraResolution.setText("CameraResolution: "+ phone.getquad_());
            if (phone.getquad_()!=null)
                holder.tvCameraResolution.setText("CameraResolution: "+ phone.getprimary_());

        }
        if (phone.getInternal()==null){
            holder.tvRam.setText("Ram: Not Available");
        }else {
            holder.tvRam.setText("Ram: " + phone.getInternal());}
        if (phone.getTechnology()==null){
            holder.tvNetworkTechnology.setText("Network technology: Not Available");
        }else {
            holder.tvNetworkTechnology.setText("Network technology: " + phone.getTechnology());}
        if (phone.getSingle()==null){
            holder.tvSecondCamera.setText("Second Camera: Not Available");
        }else {
            holder.tvSecondCamera.setText("Second Camera: " + phone.getSingle());}
        holder.btnSearch.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailsActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            Log.e("phone before", new Gson().toJson(phoneList.get(position)));
            intent.putExtra("mobile", phoneList.get(position));
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return phoneList !=null? phoneList.size():0;
    }

    public void setPhoneData(List<Phone> phoneList) { this.phoneList = phoneList;
    notifyDataSetChanged();}



    class ViewHolder extends RecyclerView.ViewHolder{


        @BindView(R.id.ivPhone)
        ImageView cIvFamily;

        @BindView(R.id.tvPhoneName)
        TextView tvPhoneName;
        @BindView(R.id.tvcameraResolution)
        TextView tvCameraResolution;
        @BindView(R.id.tvRam)
        TextView tvRam;
        @BindView(R.id.tvSecondCamera)
        TextView tvSecondCamera;
        @BindView(R.id.tvNetworktechnology)
        TextView tvNetworkTechnology;

        @BindView(R.id.btnSearch)
        Button btnSearch;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }


    }
}
