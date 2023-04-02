package com.example.zodiacproject

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ZodiacApiService {
    @GET("/horoscopes")
    suspend fun getZodiacSignData():List<ZodiacSignApiData>
}