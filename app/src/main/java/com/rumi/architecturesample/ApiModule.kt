package com.rumi.architecturesample

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiModule {
    private val BASE_URL = "https://jsonplaceholder.typicode.com/"


    fun getRetrofitInstance(): ApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build().create(ApiService::class.java)
    }
}