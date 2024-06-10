package com.example.weatherapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity3 : AppCompatActivity() {

    // declare variables

    private lateinit var textView4: TextView
    private lateinit var textView5: TextView
    private lateinit var textView6: TextView
    private lateinit var textView7: TextView

    private lateinit var buttonBack: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)

        // initialise variables

        textView4 = findViewById(R.id.textView4)
        textView5 = findViewById(R.id.textView5)
        textView6 = findViewById(R.id.textView6)
        textView7 = findViewById(R.id.textView7)

        buttonBack = findViewById(R.id.buttonBack)

        val dayArray = intent.getStringArrayExtra("dayArray")?.toList()?: emptyList()
        val temperatureArrayMin = intent.getStringArrayExtra("temperatureArrayMin")?.toList()?: emptyList()
        val temperatureArrayMax = intent.getStringArrayExtra("temperatureArrayMax")?.toList()?: emptyList()
        val weatherArrayConditions = intent.getStringArrayExtra("weatherArrayConditions")?.toList()?: emptyList()

        val  DayofWeek = StringBuilder()
        for ((index, day) in dayArray.withIndex()) {
            DayofWeek.append("Day $index: $day \n")
        }

        val temperatureCelsiusMin = StringBuilder()
        for ((index, temperatureMin) in temperatureArrayMin.withIndex()) {
            temperatureCelsiusMin.append("Min $index: $temperatureMin \n")
        }

        val temperatureCelsiusMax = StringBuilder()
        for ((index, temperatureMax) in temperatureArrayMax.withIndex()) {
            temperatureCelsiusMax.append("Max $index: $temperatureMax \n")
        }

        val weatherConditions = StringBuilder()
        for ((index, note) in weatherArrayConditions.withIndex()) {
            weatherConditions.append("Note $index: $note \n")
        }

        textView4.text = DayofWeek.toString()
        textView5.text = temperatureCelsiusMin.toString()
        textView6.text = temperatureCelsiusMax.toString()
        textView7.text = weatherConditions.toString()

        // Button to navigate back to the previous screen

        buttonBack.setOnClickListener {
            finish()

        }

    }
}