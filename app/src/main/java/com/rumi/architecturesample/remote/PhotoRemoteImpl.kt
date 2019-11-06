package com.rumi.architecturesample.remote

import com.rumi.architecturesample.Photo
import com.rumi.architecturesample.repository.PhotoRepository

class PhotoRemoteImpl constructor(val apiService: ApiService): PhotoRepository.Remote {

    override suspend fun fetchPhotos(): List<Photo> {
        return apiService.fetchPhotos()
    }
}