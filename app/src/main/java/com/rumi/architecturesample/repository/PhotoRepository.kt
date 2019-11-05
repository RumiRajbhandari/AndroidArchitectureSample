package com.rumi.architecturesample.repository

import com.rumi.architecturesample.Photo

interface PhotoRepository {
    suspend fun insertPhoto(photo: Photo)
    fun insertPhotos(photos: List<Photo>)
}