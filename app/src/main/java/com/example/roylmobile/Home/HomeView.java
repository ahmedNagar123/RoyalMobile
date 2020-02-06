package com.example.roylmobile.Home;

import com.example.roylmobile.Model.Phono;

import java.util.List;

public interface HomeView {
    void fetchPhono(String brand, String token);
    void view(List<Phono> phono);
    void errorConnection();
    void errorFalid();

}
