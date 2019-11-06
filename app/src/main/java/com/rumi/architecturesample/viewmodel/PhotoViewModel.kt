package com.rumi.architecturesample.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.rumi.architecturesample.Photo
import com.rumi.architecturesample.data.model.PhotoEntity
import com.rumi.architecturesample.repository.PhotoRepositoryImpl
import kotlinx.coroutines.launch

class PhotoViewModel(application: Application, private val repositoryImpl: PhotoRepositoryImpl) :
    AndroidViewModel(application) {


    fun insertPhoto(photo: Photo) = viewModelScope.launch {
        repositoryImpl.insertPhoto(photo)
    }

    fun insertPhotos(photos: List<Photo>) = viewModelScope.launch {
        repositoryImpl.insertPhotos(photos)
    }

    suspend fun fetchPhotos(): List<Photo> {
        return repositoryImpl.fetchPhotos()
    }

    suspend fun getPhoto(id: Int): LiveData<PhotoEntity>{
        return repositoryImpl.fetchPhoto(id)
    }
}