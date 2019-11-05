package com.rumi.architecturesample.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rumi.architecturesample.Photo
import com.rumi.architecturesample.data.model.PhotoEntity

@Dao
interface PhotoDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertPhoto(photo:PhotoEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertPhotos(photos:List<PhotoEntity>)

    @Query("select * from photo")
     fun fetchPhotos(): LiveData<List<PhotoEntity>>
}