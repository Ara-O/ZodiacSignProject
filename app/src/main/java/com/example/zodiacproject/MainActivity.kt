package com.example.zodiacproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    val db: ZodiacDatabase by lazy { ZodiacDatabase.getDatabase(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val zodiacDao = db.zodiacDao()

        val zodiacSigns = listOf(
            ZodiacSign("Aries", "Courageous and Energetic.", "Ram", "April", ""),
            ZodiacSign("Taurus", "Known for being reliable, practical, ambitious and sensual.", "Bull", "May", ""),
            ZodiacSign("Gemini", "Gemini-born are clever and intellectual.", "Twins", "June", ""),
            ZodiacSign("Cancer", "Tenacious, loyal and sympathetic.", "Crab", "July", ""),
            ZodiacSign("Leo", "Warm, action-oriented and driven by the desire to be loved and admired.", "Lion", "August", ""),
            ZodiacSign("Virgo", "Methodical, meticulous, analytical and mentally astute.", "Virgin", "September", ""),
            ZodiacSign("Libra", "Librans are famous for maintaining balance and harmony.", "Scales", "October", ""),
            ZodiacSign("Scorpio", "Strong willed and mysterious.", "Scorpion", "November", ""),
            ZodiacSign("Sagittarius", "Born adventurers.", "Archer", "December", ""),
            ZodiacSign("Capricorn", "The most determined sign in the Zodiac.", "Goat", "January", ""),
            ZodiacSign("Aquarius", "Humanitarians to the core", "Water Bearer", "February", ""),
            ZodiacSign("Pisces", "Proverbial dreamers of the Zodiac.", "Fish", "March", "")
        )
        lifecycleScope.launch {


            zodiacDao.clearDatabase()

            try {
                val zodiacApi =  RetrofitHelper.getInstance().create(ZodiacApiService::class.java)
                val result = zodiacApi.getZodiacSignData()
                result.forEachIndexed { index, zodiacSignHoroscope ->
                    zodiacSigns[index].horoscope = zodiacSignHoroscope.title.toString()
                }

            } catch (e: Exception) {
                Log.d("Failure:", "${e.message}")
            }

            for(sign in zodiacSigns){
                zodiacDao.insertIntoZodiacTable(sign)
            }

            val listOfZodiacSigns: List<ZodiacSign> = zodiacDao.getAllZodiacSigns()

            val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
            recyclerView.adapter = ItemAdapter(applicationContext, listOfZodiacSigns)
            recyclerView.setHasFixedSize(true)

        }

    }
}