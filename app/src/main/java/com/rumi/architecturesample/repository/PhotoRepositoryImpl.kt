package com.rumi.architecturesample.repository

import androidx.lifecycle.LiveData
import com.rumi.architecturesample.Photo
import com.rumi.architecturesample.data.model.PhotoEntity

class PhotoRepositoryImpl(val local: PhotoRepository.Local, val remote: PhotoRepository.Remote) :
    PhotoRepository.Local, PhotoRepository.Remote {

    override suspend fun insertPhoto(photo: Photo) {
        local.insertPhoto(photo)
    }

    override suspend fun insertPhotos(photos: List<Photo>) {
        local.insertPhotos(photos)
    }

    override suspend fun fetchPhotos(): List<Photo> {
        return remote.fetchPhotos()
    }

    override suspend fun fetchPhoto(id: Int): LiveData<PhotoEntity> {
        return local.fetchPhoto(id)
    }
}