package com.example.zodiacproject

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ZodiacSign::class], version = 1)
abstract class ZodiacDatabase: RoomDatabase() {
    abstract fun zodiacDao(): ZodiacDao

    companion object {
        @Volatile
        private var INSTANCE: ZodiacDatabase? = null

        fun getDatabase(context: Context): ZodiacDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    ZodiacDatabase::class.java,
                    "zodiac_signs_db"
                ).build()
                INSTANCE = instance

                instance
            }
        }
    }
}