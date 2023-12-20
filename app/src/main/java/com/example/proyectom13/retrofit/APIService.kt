package com.example.proyectom13.retrofit

import com.example.proyectom13.Cuidador
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    @GET
    suspend fun getCuidadores(@Url url:String):Response<List<Cuidador>>
}