package com.rumi.architecturesample

import retrofit2.http.GET

interface ApiService {

    @GET("photos")
    suspend fun getPic2(): List<RetroPhoto>
}