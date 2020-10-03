package com.example.roylmobile.api;
import com.example.roylmobile.Model.Phone;
import com.example.roylmobile.utils.Constants;
import java.util.List;
import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private PhoneApi phoneApi;
    private static RetrofitClient INESTANCE;


    public RetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        phoneApi = retrofit.create(PhoneApi.class);
    }
    public static RetrofitClient getINESTANCE() {
        if (INESTANCE == null) {
            INESTANCE = new RetrofitClient();
        }

        return INESTANCE;
    }

    public Observable<List<Phone>> getPhone(String brand, String token){
        return phoneApi.getPhone(brand,token);
    }
}

