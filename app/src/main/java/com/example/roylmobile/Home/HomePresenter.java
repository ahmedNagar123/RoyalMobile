package com.example.roylmobile.Home;

//
//public class HomePresenter implements HomeView, Callback<List<Phono>> {
//}
////    public HomePresenter(HomeView homeView) {
//        this.homeView = homeView;
//    }
//
////    @Override
//    public void fetchPhono(String brand, String token) {
//        Retrofit retrofit= RetrofitClient.getInstance();
//        PhonoApi phonoApus=retrofit.create(PhonoApi.class);
//        Call<List<Phono>> call= phonoApus.getPhone(brand ,token );
//        call.enqueue(this);
//
//    }
//
//
//    @Override
//    public void view(List<Phono> phono) {
//        homeView.view(phono);
//
//    }
//
//    @Override
//    public void errorConnection() {
//        homeView.errorConnection();
//    }
//
//    @Override
//    public void errorFalid() {
//        homeView.errorFalid();
//    }
//
//
//    @Override
//    public void onResponse(Call<List<Phono>> call, Response<List<Phono>> response) {
//        if (response.isSuccessful()){
//            view(response.body());
//        }else {
//            errorFalid();
//        }
//    }
//
//    @Override
//    public void onFailure(Call<List<Phono>> call, Throwable t) {
//        errorConnection();
//    }
//}