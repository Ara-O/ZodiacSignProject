package com.example.zodiacproject

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "zodiac_signs_db")
data class ZodiacSign (
    @PrimaryKey val name: String,
    val description: String,
    val symbol:String,
    val month: String
)