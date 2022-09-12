package com.demo.menuapp.network;

public interface ApiCallback<T> {
    void onSuccess(T body);
    void onError(Throwable t);
}
