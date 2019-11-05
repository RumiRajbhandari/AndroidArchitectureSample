package com.rumi.architecturesample.data

import android.content.Context
import com.rumi.architecturesample.data.dao.PhotoDao

class DatabaseManager(context: Context) {
    private val instance = SampleRoomDatabase.getDatabase(context)

    fun beginTransaction() {
        instance.beginTransaction()
    }

    fun endTransaction() {
        instance.setTransactionSuccessful()
        instance.endTransaction()
    }

    fun getPhotoDao(): PhotoDao {
        return instance.photoDao()
    }

    fun dropDatabase() {
        instance.clearAllTables()
    }
}