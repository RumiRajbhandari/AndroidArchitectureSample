package com.rumi.architecturesample.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.rumi.architecturesample.Photo
import com.rumi.architecturesample.data.DatabaseManager
import com.rumi.architecturesample.data.model.PhotoEntity
import com.rumi.architecturesample.repository.PhotoRepository
import kotlinx.coroutines.Dispatchers

class PhotoLocalImpl(val databaseManager: DatabaseManager): PhotoRepository.Local {
    override suspend fun insertPhoto(photo: Photo) {
        databaseManager.getPhotoDao().insertPhoto(mapToPhotoEntity(photo))
    }

    override suspend fun insertPhotos(photos: List<Photo>) {
        val photoEntityList = photos.map { mapToPhotoEntity(it) }
        databaseManager.getPhotoDao().insertPhotos(photoEntityList)
    }

    fun mapToPhotoEntity(photo: Photo): PhotoEntity {
        return PhotoEntity(photo.id, photo.title)
    }

    override suspend fun fetchPhoto(id: Int): LiveData<PhotoEntity> {
      return liveData(Dispatchers.IO) {
           emitSource(databaseManager.getPhotoDao().fetchPhoto(id))
       }

    }
}