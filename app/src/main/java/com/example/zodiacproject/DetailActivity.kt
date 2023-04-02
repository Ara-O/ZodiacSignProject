package com.example.zodiacproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import org.w3c.dom.Text

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val name = intent.getStringExtra("zodiac_name")
        val description = intent.getStringExtra("zodiac_description")
        val symbol = intent.getStringExtra("zodiac_symbol")
        val month = intent.getStringExtra("zodiac_month")
        val horoscope = intent.getStringExtra("zodiac_horoscope")

        findViewById<TextView>(R.id.zodiacName).setText(name)
        findViewById<TextView>(R.id.zodiacDescription).setText(description)
        findViewById<TextView>(R.id.zodiacMonth).setText(month)
        findViewById<TextView>(R.id.zodiacSymbol).setText(symbol)
        findViewById<TextView>(R.id.zodiacHoroscope).setText(horoscope)


        Log.d("valus", name + description + symbol + month)
    }
}