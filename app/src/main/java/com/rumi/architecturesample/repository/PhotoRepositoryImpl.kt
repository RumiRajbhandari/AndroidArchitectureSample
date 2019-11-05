package com.rumi.architecturesample.repository

import com.rumi.architecturesample.Photo
import com.rumi.architecturesample.data.dao.PhotoDao
import com.rumi.architecturesample.data.model.PhotoEntity

class PhotoRepositoryImpl  (val photoDao: PhotoDao): PhotoRepository {

    override suspend fun insertPhoto(photo: Photo) {
        photoDao.insertPhoto(mapToPhotoEntity(photo))
    }

    override fun insertPhotos(photos: List<Photo>) {
        val photoEntityList = photos.map { mapToPhotoEntity(it) }
        photoDao.insertPhotos(photoEntityList)
    }

    fun mapToPhotoEntity(photo: Photo): PhotoEntity{
        return PhotoEntity(photo.id, photo.title)
    }
}