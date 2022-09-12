package com.demo.menuapp.network;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;

public interface ApiClient {
    <S> S createService(Class<S> clazz);

    <T> Converter<ResponseBody, T> responseBodyConverter(Type type, Annotation[] annotations);
}
