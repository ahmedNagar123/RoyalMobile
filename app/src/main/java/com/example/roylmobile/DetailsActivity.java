package com.example.roylmobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.roylmobile.Model.Phono;
import com.example.roylmobile.base.ParentActivity;
import com.example.roylmobile.utils.Util;
import com.google.gson.Gson;

import butterknife.BindView;

public class DetailsActivity extends ParentActivity {


    @BindView(R.id.tvPhoneName)
    TextView tvPhoneName;
    @BindView(R.id.tvNetworktechnology)
    TextView tvNetworktechnology;

    @BindView(R.id.ivPhotoPhoneMain)
    ImageView ivPhotoPhoneMain;

    @BindView(R.id.ivPhotoSubPhone1)
    ImageView ivPhotoSubPhone1;

    @BindView(R.id.ivPhotoSubPhone2)
    ImageView ivPhotoSubPhone2;

    @BindView(R.id.ivPhotoSubPhone3)
    ImageView ivPhotoSubPhone3;

    @BindView(R.id.ivPhotoSubPhone4)
    ImageView ivPhotoSubPhone4;

    @BindView(R.id.tvBrand)
    TextView tvBrand;

    @BindView(R.id.tvOperatingSystemType)
    TextView tvOperatingSystemType;

    @BindView(R.id.tvPackagethickness)
    TextView tvPackagethickness;

    @BindView(R.id.tvStoragecapacity)
    TextView tvStoragecapacity;

    @BindView(R.id.tvDualSim)
    TextView tvDualSim;

    @BindView(R.id.tvDisplayType)
    TextView tvDisplayType;

    @BindView(R.id.tvDisplayResolution)
    TextView tvDisplayResolution;

    @BindView(R.id.tvLoudSpeaker)
    TextView tvLoudSpeaker;

    @BindView(R.id.tvCardSlot)
    TextView tvCardSlot;
    @BindView(R.id.tvSound)
    TextView tvSound;
    @BindView(R.id.tvBluetooth)
    TextView tvBluetooth;
    @BindView(R.id.tvRadio)
    TextView tvRadio;
    @BindView(R.id.tvUsb)
    TextView tvUsb;
    @BindView(R.id.tvColors)
    TextView tvColors;
    @BindView(R.id.tvSensor)
    TextView tvSensor;
    @BindView(R.id.tvVideo)
    TextView tvVideo;
    @BindView(R.id.tvChipsetManufacturer)
    TextView tvChipsetManufacturer;

    @BindView(R.id.tvProtectionLayer)
    TextView tvProtectionLayer;

    @BindView(R.id.tvGpu)
    TextView tvGpu;

    @BindView(R.id.tvBuildProduct)
    TextView tvBuildProduct;

    @BindView(R.id.tvRearcamera)
    TextView tvRearCamera;

    @BindView(R.id.tvFrontcamera)
    TextView tvFrontCamera;

    @BindView(R.id.tvchargingtype)
    TextView tvchargingtype;
    @BindView(R.id.tvBatteryCapacity)
    TextView tvBatteryCapacity;

    @BindView(R.id.tvMobileweight)
    TextView tvMobileweight;
    @BindView(R.id.tvWlan)
    TextView tvWlan;
    @BindView(R.id.tvGps)
    TextView tvGps;

    @BindView(R.id.tvMobileweightKgs)
    TextView tvMobileweightKgs;
    @BindView(R.id.tvReadLess)
    TextView tvReadLess;


    @BindView(R.id.tvReadMore)
    TextView tvReadMore;

    @BindView(R.id.aciBtnBack)
    AppCompatImageButton aciBtnBack;
    @BindView(R.id.llSpecification)
    LinearLayout llSpecification;


    @Override
    protected int getLayoutResource() {
        return R.layout.activity_details;
    }

    @Override
    protected boolean isFullScreen() {
        return false;
    }

    @Override
    protected void init() {

        Phono phono = (Phono)getIntent().getExtras().getSerializable("mobile");

        Log.e("phone after",new Gson().toJson(phono));
/*
        if (phono.getDeviceName()==null){
            tvPhoneName.setText("Not Avaliable");}
        else if (phono.getBrand()==null){
            tvBrand.setText("Not Avaliable");}
        else if (phono.getSim()==null){
            tvDualSim.setText("----");
            tvDualSim1.setText("----");}
        else if (phono.getInternal()==null) {
            tvStoragecapacity.setText("---");
            tvStoragecapacity1.setText("---");
            tvDataBase.setText("Not Avaliable");
            tvRam.setText("Not Avaliable");
        }else if (phono.getTechnology()==null){
            tvHandfone1.setText("  ");
            tvHandfone.setText("Not Avaliable");
        }
        else if(phono.getSize()==null) {
            tvscreen.setText("Not Avaliable");
        }else if (phono.getTriple()==null && phono.getdual_()==null ){
            tvRearCamera.setText("Rear camera:Not Avaliable");
        }else if (phono.getSingle()==null ){
            tvFrontCamera.setText("FrontCamera:Not Avaliable");}
        else if (phono.getBatteryC()==null){
            tvbattery.setText("Not Avaliable");}
        else if (phono.getWeight()==null){
            tvMobileweight.setText("Not Avaliable");}
        else if (phono.getSensors()==null){
            tvInformationLock.setText("Not Avaliable");}
        else {
            tvPhoneName.setText(phono.getDeviceName());
            tvDualSim1.setText(phono.getSim()+"SIM");
            tvBrand.setText(phono.getBrand());
            tvOperatingSystemType.setText(phono.getOs());
            tvPackagethickness.setText(phono.getDimensions());
            tvStoragecapacity.setText(phono.getInternal());
            tvStoragecapacity1.setText(phono.getInternal());
            tvDualSim.setText(phono.getSim());
            tvDataBase.setText(phono.getInternal());
            tvRam.setText(phono.getInternal());
            tvHandfone.setText(phono.getTechnology());
            tvHandfone1.setText(phono.getTechnology());
            tvscreen.setText(phono.getSize());
            tvRearCamera.setText("RearCamera "+phono.getTriple());
            tvRearCamera.setText("RearCamera "+phono.getdual_());
            tvFrontCamera.setText("FrontCamera "+phono.getSingle());
            tvbattery.setText(phono.getBatteryC());
            tvMobileweight.setText(phono.getWeight());
            tvInformationLock.setText(phono.getSensors());
            Log.i("mobname",phono.getDeviceName());
        }
        */
        if (phono.getDeviceName()!=null && phono.getSim()!=null && phono.getInternal()!=null && phono.getTechnology()!=null) {
            tvPhoneName.setText(new StringBuilder().append(phono.getDeviceName()).append(" ")
                    .append( Util.CustomString(phono.getSim())).append("-").append(phono.getInternal())
                    .append(",").append(phono.getTechnology()).toString());
        }else
            tvPhoneName.setText("Not Avaliable");
        if (phono.getBrand()!=null)
            tvBrand.setText(phono.getBrand());
        else
            tvBrand.setText("Not Avaliable");
        if (phono.getOs()!=null)
            tvOperatingSystemType.setText(phono.getOs());
        else
            tvOperatingSystemType.setText("__");

        if (phono.getSim()!=null){
            tvDualSim.setText(phono.getSim());
        }
        else {
            tvDualSim.setText("----");
        }
        if (phono.getInternal()!=null){
            tvStoragecapacity.setText(phono.getInternal());
        } else{
            tvStoragecapacity.setText("---");
        } if (phono.getTechnology()!=null){
            tvNetworktechnology.setText(phono.getTechnology());
        } else{
            tvNetworktechnology.setText("Not Avaliable");
        }

        if (phono.getTriple()==null && phono.getdual_()==null && phono.getprimary_()==null && phono.getquad_()==null ){
            tvRearCamera.setText("Not Avaliable");
        }else {
            if (phono.getTriple()!=null )
                tvRearCamera.setText( phono.getTriple());
            if (phono.getdual_()!=null)
                tvRearCamera.setText(phono.getdual_());
            if (phono.getprimary_()!=null)
                tvRearCamera.setText(phono.getprimary_());
            if (phono.getquad_()!=null)
                tvRearCamera.setText(phono.getquad_());
        }
        if (phono.getSingle()!=null )
            tvFrontCamera.setText(phono.getSingle());
        else
            tvFrontCamera.setText("Not Avaliable");

        if (phono.getWeight()!=null)
            tvMobileweight.setText(phono.getWeight());
        else
            tvMobileweight.setText("Not Avaliable");
        if (phono.getsar()!=null)
            tvMobileweightKgs.setText(phono.getsar());
        else
            tvMobileweightKgs.setText("Not Avaliable");
        if (phono.getType()!=null)
            tvDisplayType.setText(phono.getType());
        else
            tvDisplayType.setText("Not Avaliable");
        if (phono.getResolution()!=null)
            tvDisplayResolution.setText(phono.getResolution());
        else
            tvDisplayResolution.setText("Not Avaliable");
        if (phono.getCardSlot()!=null)
            tvCardSlot.setText(phono.getCardSlot());
        else
            tvCardSlot.setText("Not Avaliable");
        if (phono.getLoudspeaker()!=null)
            tvLoudSpeaker.setText(phono.getLoudspeaker());
        else
            tvLoudSpeaker.setText("Not Avaliable");
        if (phono.getSoundC()!=null)
            tvSound.setText(phono.getSoundC());
        else
            tvSound.setText("Not Avaliable");
        if (phono.getWlan()!=null)
            tvWlan.setText(phono.getWlan());
        else
            tvWlan.setText("Not Avaliable");
        if (phono.getBluetooth()!=null)
            tvBluetooth.setText(phono.getBluetooth());
        else
            tvBluetooth.setText("Not Avaliable");
        if (phono.getGps()!=null)
            tvGps.setText(phono.getGps());
        else
            tvGps.setText("Not Avaliable");
        if (phono.getRadio()!=null)
            tvRadio.setText(phono.getRadio());
        else
            tvRadio.setText("Not Avaliable");
        if (phono.getUsb()!=null)
            tvUsb.setText(phono.getUsb());
        else
            tvUsb.setText("Not Avaliable");
        if (phono.getBatteryC()!=null)
            tvBatteryCapacity.setText(phono.getBatteryC());
        else
            tvBatteryCapacity.setText("Not Avaliable");
        if (phono.getColors()!=null)
            tvColors.setText(phono.getColors());
        else
            tvColors.setText("Not Avaliable");
        if (phono.getSensors()!=null)
            tvSensor.setText(phono.getSensors());
        else
            tvSensor.setText("Not Avaliable");
        if (phono.getVideo()!=null)
            tvVideo.setText(phono.getVideo());
        else
            tvVideo.setText("Not Avaliable");
        if (phono.getChipset()!=null)
            tvChipsetManufacturer.setText(phono.getChipset());
        else
            tvChipsetManufacturer.setText("Not Avaliable");
        if (phono.getprotection_()!=null)
            tvProtectionLayer.setText(phono.getprotection_());
        else
            tvProtectionLayer.setText("Not Avaliable");
        if (phono.getGpu()!=null)
            tvGpu.setText(phono.getGpu());
        else
            tvGpu.setText("Not Avaliable");
        if (phono.getbuild()!=null)
            tvBuildProduct.setText(phono.getbuild());
        else
            tvBuildProduct.setText("Not Avaliable");
        if (phono.getCharging()!=null)
            tvchargingtype.setText(phono.getCharging());
        else
            tvchargingtype.setText("Not Avaliable");
        if (phono.getSize()!=null)
            tvPackagethickness.setText(phono.getSize());
        else
            tvPackagethickness.setText("Not Avaliable");


        aciBtnBack.setOnClickListener(this);
        tvReadMore.setOnClickListener(this);
        tvReadLess.setOnClickListener(this);

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
            case R.id.tvReadMore:
                llSpecification.setVisibility(View.VISIBLE);
                tvReadLess.setVisibility(View.VISIBLE);
                tvReadMore.setVisibility(View.GONE);
                break;
            case R.id.tvReadLess:
                llSpecification.setVisibility(View.GONE);
                tvReadLess.setVisibility(View.GONE);
                tvReadMore.setVisibility(View.VISIBLE);
                break;

        }


    }
}

