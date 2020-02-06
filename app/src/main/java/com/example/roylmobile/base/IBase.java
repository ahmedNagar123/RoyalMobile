package com.example.roylmobile.base;

import android.content.Context;

public interface IBase {

    Context getContext();

    void error(String string);

    void error(int code);

    void failure(Throwable t);
}
