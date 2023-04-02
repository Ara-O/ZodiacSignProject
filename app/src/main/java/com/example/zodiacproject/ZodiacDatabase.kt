package com.example.zodiacproject

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [ZodiacSign::class], version = 2)
abstract class ZodiacDatabase: RoomDatabase() {

    abstract fun zodiacDao(): ZodiacDao

    companion object {
        @Volatile
        private var INSTANCE: ZodiacDatabase? = null

        //Apparently I need to migrate the database just to be able to add a column :(
        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE 'zodiac_signs_db' ADD COLUMN 'horoscope' TEXT NOT NULL DEFAULT 'undefined'")
            }
        }

        fun getDatabase(context: Context): ZodiacDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    ZodiacDatabase::class.java,
                    "zodiac_signs_db"
                ).addMigrations(MIGRATION_1_2).build()
                INSTANCE = instance

                instance
            }
        }
    }
}