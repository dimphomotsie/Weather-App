package com.example.weatherapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class MainActivity2 : AppCompatActivity() {

    // declare variables
    private lateinit var etDay: EditText
    private  lateinit var etMin: EditText
    private lateinit var etMax: EditText
    private lateinit var etWeatherCondition: EditText
    private lateinit var tvMessage: TextView

    private lateinit var buttonCalculate : Button
    private lateinit var buttonClear : Button
    private lateinit var buttonNext2 : Button
    private lateinit var buttonExit : Button

    // declare arrays
    private val dayArray = mutableListOf<String>()
    private val temperatureArrayMin = mutableListOf<Float>()
    private val temperatureArrayMax = mutableListOf<Float>()
    private val weatherArrayCondition = mutableListOf<String>()


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        // Initialize variables

        etDay = findViewById(R.id.etDay)
        etMin = findViewById(R.id.etMin)
        etMax = findViewById(R.id.etMax)
        etWeatherCondition = findViewById(R.id.etWeatherCondition)
        tvMessage = findViewById(R.id.tvMessage)

        buttonCalculate = findViewById(R.id.buttonCalculate)
        buttonClear = findViewById(R.id.buttonClear)
        buttonNext2 = findViewById(R.id.buttonNext2)
        buttonExit = findViewById(R.id.buttonExit)

        // Set click listeners

        buttonClear.setOnClickListener {
            etDay.setText("")
            etMin.setText("")
            etMax.setText("")
            etWeatherCondition.setText("")
        }

        buttonCalculate.setOnClickListener {
            val temperatureDay = etDay.text.toString()
            val temperatureMin = etMin.text.toString()
            val temperatureMax = etMax.text.toString()
            val weatherConditions = etWeatherCondition.text.toString()

            if (temperatureDay.isNotEmpty() && temperatureMin.isNotEmpty() && temperatureMax.isNotEmpty()) {
                try {
                    dayArray.add(temperatureDay)
                    temperatureArrayMin.add(temperatureMin.toFloat())
                    temperatureArrayMax.add(temperatureMax.toFloat())
                    weatherArrayCondition.add(weatherConditions)
                    etDay.text.clear()
                    etMin.text.clear()
                    etMax.text.clear()
                    etWeatherCondition.text.clear()
                } catch (e: NumberFormatException) {
                    tvMessage.text = "Please enter a valid number"

                }

            } else {
                tvMessage.text = "Input cannot be empty"
            }
            val average1 = temperatureArrayMin.average()
            val average2 = temperatureArrayMax.average()
            val overallAverage = (average1 + average2) / 2
            tvMessage.text = " Average Temperature: $overallAverage"
        }



        buttonNext2.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            intent.putExtra("dayArray", dayArray.toTypedArray())
            intent.putExtra("temperatureArrayMin", temperatureArrayMin.toFloatArray())
            intent.putExtra("temperatureArrayMax", temperatureArrayMax.toFloatArray())
            intent.putExtra("weatherArrayCondition", weatherArrayCondition.toTypedArray())
            startActivity(intent)
        }
        buttonExit.setOnClickListener {
            finishAffinity()
        }

    }



    }
