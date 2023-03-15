package com.example.zodiacproject

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ZodiacDao {
    @Query("SELECT * FROM zodiac_signs_db")
    suspend fun getAllZodiacSigns(): List<ZodiacSign>

    @Insert()
    suspend fun insertIntoZodiacTable(sign: ZodiacSign)

    @Query("DELETE FROM zodiac_signs_db")
    suspend fun clearDatabase()
}