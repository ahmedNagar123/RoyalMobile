package com.example.roylmobile;

import androidx.appcompat.widget.AppCompatImageButton;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.roylmobile.Model.Phone;
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

        Phone phone = (Phone)getIntent().getExtras().getSerializable("mobile");

        Log.e("phone after",new Gson().toJson(phone));
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
        if (phone.getDeviceName()!=null && phone.getSim()!=null && phone.getInternal()!=null && phone.getTechnology()!=null) {
            tvPhoneName.setText(new StringBuilder().append(phone.getDeviceName()).append(" ")
                    .append( Util.CustomString(phone.getSim())).append("-").append(phone.getInternal())
                    .append(",").append(phone.getTechnology()).toString());
        }else
            tvPhoneName.setText("Not Avaliable");
        if (phone.getBrand()!=null)
            tvBrand.setText(phone.getBrand());
        else
            tvBrand.setText("Not Avaliable");
        if (phone.getOs()!=null)
            tvOperatingSystemType.setText(phone.getOs());
        else
            tvOperatingSystemType.setText("__");

        if (phone.getSim()!=null){
            tvDualSim.setText(phone.getSim());
        }
        else {
            tvDualSim.setText("----");
        }
        if (phone.getInternal()!=null){
            tvStoragecapacity.setText(phone.getInternal());
        } else{
            tvStoragecapacity.setText("---");
        } if (phone.getTechnology()!=null){
            tvNetworktechnology.setText(phone.getTechnology());
        } else{
            tvNetworktechnology.setText("Not Avaliable");
        }

        if (phone.getTriple()==null && phone.getdual_()==null && phone.getprimary_()==null && phone.getquad_()==null ){
            tvRearCamera.setText("Not Avaliable");
        }else {
            if (phone.getTriple()!=null )
                tvRearCamera.setText( phone.getTriple());
            if (phone.getdual_()!=null)
                tvRearCamera.setText(phone.getdual_());
            if (phone.getprimary_()!=null)
                tvRearCamera.setText(phone.getprimary_());
            if (phone.getquad_()!=null)
                tvRearCamera.setText(phone.getquad_());
        }
        if (phone.getSingle()!=null )
            tvFrontCamera.setText(phone.getSingle());
        else
            tvFrontCamera.setText("Not Avaliable");

        if (phone.getWeight()!=null)
            tvMobileweight.setText(phone.getWeight());
        else
            tvMobileweight.setText("Not Avaliable");
        if (phone.getsar()!=null)
            tvMobileweightKgs.setText(phone.getsar());
        else
            tvMobileweightKgs.setText("Not Avaliable");
        if (phone.getType()!=null)
            tvDisplayType.setText(phone.getType());
        else
            tvDisplayType.setText("Not Avaliable");
        if (phone.getResolution()!=null)
            tvDisplayResolution.setText(phone.getResolution());
        else
            tvDisplayResolution.setText("Not Avaliable");
        if (phone.getCardSlot()!=null)
            tvCardSlot.setText(phone.getCardSlot());
        else
            tvCardSlot.setText("Not Avaliable");
        if (phone.getLoudspeaker()!=null)
            tvLoudSpeaker.setText(phone.getLoudspeaker());
        else
            tvLoudSpeaker.setText("Not Avaliable");
        if (phone.getSoundC()!=null)
            tvSound.setText(phone.getSoundC());
        else
            tvSound.setText("Not Avaliable");
        if (phone.getWlan()!=null)
            tvWlan.setText(phone.getWlan());
        else
            tvWlan.setText("Not Avaliable");
        if (phone.getBluetooth()!=null)
            tvBluetooth.setText(phone.getBluetooth());
        else
            tvBluetooth.setText("Not Avaliable");
        if (phone.getGps()!=null)
            tvGps.setText(phone.getGps());
        else
            tvGps.setText("Not Avaliable");
        if (phone.getRadio()!=null)
            tvRadio.setText(phone.getRadio());
        else
            tvRadio.setText("Not Avaliable");
        if (phone.getUsb()!=null)
            tvUsb.setText(phone.getUsb());
        else
            tvUsb.setText("Not Avaliable");
        if (phone.getBatteryC()!=null)
            tvBatteryCapacity.setText(phone.getBatteryC());
        else
            tvBatteryCapacity.setText("Not Avaliable");
        if (phone.getColors()!=null)
            tvColors.setText(phone.getColors());
        else
            tvColors.setText("Not Avaliable");
        if (phone.getSensors()!=null)
            tvSensor.setText(phone.getSensors());
        else
            tvSensor.setText("Not Avaliable");
        if (phone.getVideo()!=null)
            tvVideo.setText(phone.getVideo());
        else
            tvVideo.setText("Not Avaliable");
        if (phone.getChipset()!=null)
            tvChipsetManufacturer.setText(phone.getChipset());
        else
            tvChipsetManufacturer.setText("Not Avaliable");
        if (phone.getprotection_()!=null)
            tvProtectionLayer.setText(phone.getprotection_());
        else
            tvProtectionLayer.setText("Not Avaliable");
        if (phone.getGpu()!=null)
            tvGpu.setText(phone.getGpu());
        else
            tvGpu.setText("Not Avaliable");
        if (phone.getbuild()!=null)
            tvBuildProduct.setText(phone.getbuild());
        else
            tvBuildProduct.setText("Not Avaliable");
        if (phone.getCharging()!=null)
            tvchargingtype.setText(phone.getCharging());
        else
            tvchargingtype.setText("Not Avaliable");
        if (phone.getSize()!=null)
            tvPackagethickness.setText(phone.getSize());
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

