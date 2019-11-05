package com.rumi.architecturesample.remote

import com.rumi.architecturesample.Photo
import retrofit2.http.GET

interface ApiService {

    @GET("photos")
    suspend fun fetchPhotos(): List<Photo>
}