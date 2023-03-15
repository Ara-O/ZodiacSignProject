package com.example.zodiacproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import org.w3c.dom.Text

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val name = intent.getStringExtra("zodiac_name")
        val description = intent.getStringExtra("zodiac_description")
        val symbol = intent.getStringExtra("zodiac_symbol")
        val month = intent.getStringExtra("zodiac_month")

        findViewById<TextView>(R.id.zodiacName).setText(name)
        findViewById<TextView>(R.id.zodiacDescription).setText(description)
        findViewById<TextView>(R.id.zodiacMonth).setText(month)
        findViewById<TextView>(R.id.zodiacSymbol).setText(symbol)

        Log.d("valus", name + description + symbol + month)
    }
}