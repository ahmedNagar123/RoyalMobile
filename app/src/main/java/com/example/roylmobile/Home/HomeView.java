package com.example.roylmobile.Home;

import com.example.roylmobile.Model.Phone;

import java.util.List;

public interface HomeView {
    void fetchPhono(String brand, String token);
    void view(List<Phone> phone);
    void errorConnection();
    void errorFalid();

}
