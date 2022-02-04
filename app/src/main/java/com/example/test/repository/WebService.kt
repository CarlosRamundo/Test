package com.example.test.repository

import com.example.test.data.model.Device
import com.example.test.util.AppConstants
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface WebService {
    @GET("devices")
    suspend fun getDevices(): Device
}

object RetrofitClent{
    val webservice by lazy{
        Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(WebService::class.java)
    }
}