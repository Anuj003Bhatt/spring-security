package com.decimal.springsecurity.rest.api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.time.Duration;

public abstract class BaseApiConfig {

    private final RxJavaCallAdapterFactory callAdapterFactory = RxJavaCallAdapterFactory.create();
    private final ScalarsConverterFactory converterFactory = ScalarsConverterFactory.create();

    private final OkHttpClient httpClient = new OkHttpClient();

    protected <T> T createApi(String baseUrl, long timeout, Class<T> clazz) {
        Duration duration = Duration.ofMillis(timeout);
        OkHttpClient.Builder clientBuilder = httpClient.newBuilder()
                .callTimeout(duration)
                .connectTimeout(duration)
                .readTimeout(duration)
                .writeTimeout(duration);
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(callAdapterFactory)
                .addConverterFactory(converterFactory)
                .client(clientBuilder.build())
                .build()
                .create(clazz);
    }
}
