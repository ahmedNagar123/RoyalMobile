package com.example.roylmobile.search;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.roylmobile.Model.Phone;
import com.example.roylmobile.api.RetrofitClient;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SearchViewModel extends ViewModel {
    MutableLiveData<List<Phone>> phoneMutableLiveData =new MutableLiveData<>();
public void getPhone(String brand, String token){
    Observable observable= RetrofitClient.getINESTANCE().getPhone(brand,token)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    Observer<List<Phone>>observer=new Observer<List<Phone>>() {
        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onNext(List<Phone> value) {
            phoneMutableLiveData.setValue(value);
        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onComplete() {

        }
    };
observable.subscribe(observer);
}

}
