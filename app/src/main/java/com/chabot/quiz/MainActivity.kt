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
lateinit var quiz: Quiz
lateinit var currentquestion: Questions

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        wirewidgets()
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
        answerX.setOnClickListener { quiz.score(0)
        nextQuestion()
        }
        answerY.setOnClickListener { quiz.score(1)
        nextQuestion()
        }
        answerZ.setOnClickListener { quiz.score(2)
        nextQuestion()
        }
        questiontext()
    }

    fun nextQuestion(){
        if(quiz.addquestions()){
            currentquestion = quiz.getnextQuestion()
        }
        else{
            questionText.text = quiz.score.toString()
        }
    }

    fun questiontext(){
        questionText.text = currentquestion.t
        answerX.text = currentquestion.a1
        answerY.text = currentquestion.a2
        answerZ.text = currentquestion.a3
    }

    private fun wirewidgets()                                            {
        questionText = findViewById(R.id.questionText)
        answerX = findViewById(R.id.answerX)
        answerY = findViewById(R.id.answerY)
        answerZ = findViewById(R.id.answerZ)

    }



}