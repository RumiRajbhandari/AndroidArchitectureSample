package com.rumi.architecturesample.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.rumi.architecturesample.Photo
import com.rumi.architecturesample.data.DatabaseManager
import com.rumi.architecturesample.repository.PhotoRepository
import com.rumi.architecturesample.repository.PhotoRepositoryImpl
import kotlinx.coroutines.launch

class PhotoViewModel(application: Application) : AndroidViewModel(application) {
    var repositoryImpl: PhotoRepository

    init {
        val photoDao = DatabaseManager(application).getPhotoDao()
        repositoryImpl = PhotoRepositoryImpl(photoDao)
    }

    fun insertPhoto(photo: Photo) = viewModelScope.launch {
        repositoryImpl.insertPhoto(photo)
    }

    fun insertPhotos(photos: List<Photo>) {
        repositoryImpl.insertPhotos(photos)
    }
}