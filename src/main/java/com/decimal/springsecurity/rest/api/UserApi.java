package com.decimal.springsecurity.rest.api;

import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.Single;

public interface UserApi {

    @POST("users/authenticate")
    @Headers({"Content-Type: application/json"})
    Single<String> authenticate(@Body String request);

    @POST("users")
    @Headers({"Content-Type: application/json"})
    Single<String> addUser(@Body String request);
}
