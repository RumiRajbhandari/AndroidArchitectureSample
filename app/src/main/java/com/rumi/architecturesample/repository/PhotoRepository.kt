package com.rumi.architecturesample.repository

import androidx.lifecycle.LiveData
import com.rumi.architecturesample.Photo
import com.rumi.architecturesample.data.model.PhotoEntity

interface PhotoRepository {
    interface Local {
        suspend fun insertPhoto(photo: Photo)
        suspend fun insertPhotos(photos: List<Photo>)
        suspend fun fetchPhoto(id: Int): LiveData<PhotoEntity>
    }

    interface Remote {
        suspend fun fetchPhotos(): List<Photo>
    }
}