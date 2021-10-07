package com.chabot.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

val TAG = "MainActivity"
lateinit var questionText : TextView
lateinit var answerX : Button
lateinit var answerY : Button
lateinit var answerZ : Button
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val inputStream = resources.openRawResource(R.raw.questions)
        val jsonText = inputStream.bufferedReader().use {
            it.readText()
        }
        Log.d(TAG, "OnCreate: $jsonText")



        val gson = Gson()
        val type = object : TypeToken<List<Questions>>() { }.type
        val question = gson.fromJson<List<Questions>>(jsonText, type)
        Log.d(TAG, "onCreate: \n${question.toString()}")
    }

    private fun wirewidgets()                                            {
        questionText = findViewById(R.id.questionText)
        answerX = findViewById(R.id.answerX)
        answerY = findViewById(R.id.answerY)
        answerZ = findViewById(R.id.answerZ                                                                                                                                                                                                                                                                                                                                                                                                                                                   )
    }



}