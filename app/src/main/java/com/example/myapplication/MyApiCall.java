package com.example.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyApiCall {

    //https://run.mocky.io/ v3/c3c11dca-b7f1-45cc-a49b-2812ac49fff0

    @GET("todos/1")
    Call<DataMOdel> getData();
}
