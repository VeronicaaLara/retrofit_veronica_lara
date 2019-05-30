package com.ejercicio_retrofit.API;

import com.ejercicio_retrofit.Grupo.Grupo;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestClient {

    @GET("5cef8c0b3000001b303cd0dd")
    Call<Grupo> getData();
}
