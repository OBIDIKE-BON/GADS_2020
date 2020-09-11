package com.stackfloat.gads2020.services;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LeadersServiceBuilder {
    private LeadersServiceBuilder() {
    }

    // Create logger
    private static HttpLoggingInterceptor logger =
            new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    // Create OkHttp Client
    private static OkHttpClient.Builder okHttp =
            new OkHttpClient.Builder().addInterceptor(logger);
    private static final String BASE_URL = "https://gadsapi.herokuapp.com";
    private static Retrofit.Builder sBuilder = new Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttp.build());
    private static Retrofit mRetrofit = sBuilder.build();

    public static <S> S buildService(Class<S> serviceType) {
        return mRetrofit.create(serviceType);
    }
}
