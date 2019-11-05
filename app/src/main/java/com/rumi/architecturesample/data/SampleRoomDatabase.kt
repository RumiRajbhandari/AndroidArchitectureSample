package com.rumi.architecturesample.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rumi.architecturesample.data.dao.PhotoDao
import com.rumi.architecturesample.data.model.PhotoEntity

@Database(entities = [
    (PhotoEntity::class)
], version = 1)
abstract class SampleRoomDatabase: RoomDatabase() {
    abstract fun photoDao(): PhotoDao

    companion object{
        @Volatile
        private var INSTANCE: SampleRoomDatabase? = null
         val databaseName = "sample_db"
        fun getDatabase(context: Context): SampleRoomDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SampleRoomDatabase::class.java,
                    databaseName
                    ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}