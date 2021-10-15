package com.chabot.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

val TAG = "MainActivity"
lateinit var questionText : TextView
lateinit var answerX : Button
lateinit var answerY : Button
lateinit var answerZ : Button
lateinit var quiz: Quiz
lateinit var currentquestion: question

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wireWidgets()


        val inputStream = resources.openRawResource(R.raw.questions)
        val jsonText = inputStream.bufferedReader().use {
            it.readText()
        }
        Log.d(TAG, "OnCreate: $jsonText")



        val gson = Gson()
        val type = object : TypeToken<List<question>>() { }.type
        val question = gson.fromJson<List<question>>(jsonText, type)
        Log.d(TAG, "onCreate: \n${question.toString()}")
        quiz = Quiz(question)
        nextQuestion()
        questiontext()
        answerX.setOnClickListener { quiz.score(0)
            if(currentquestion.correct == 0) {
                Toast.makeText(this@MainActivity, "Correct", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this@MainActivity, "Wrong", Toast.LENGTH_SHORT).show()
            }
        nextQuestion()
        }
        answerY.setOnClickListener { quiz.score(1)
            if(currentquestion.correct == 1) {
                Toast.makeText(this@MainActivity, "Correct", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this@MainActivity, "Wrong", Toast.LENGTH_SHORT).show()
            }
        nextQuestion()
        }
        answerZ.setOnClickListener { quiz.score(2)
            if(currentquestion.correct == 2) {
                Toast.makeText(this@MainActivity, "Correct", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this@MainActivity, "Wrong", Toast.LENGTH_SHORT).show()
            }
        nextQuestion()
        }
    }

    fun nextQuestion(){
        if(quiz.addquestions()){
            currentquestion = quiz.getnextQuestion()
            questiontext()
        }
        else{
            questionText.text = quiz.score.toString()
        }
    }

    fun questiontext(){
        questionText.text = currentquestion.question
        answerX.text = currentquestion.a1
        answerY.text = currentquestion.a2
        answerZ.text = currentquestion.a3
    }

    private fun wireWidgets()                                            {
        questionText = findViewById(R.id.questionText)
        answerX = findViewById(R.id.answerX)
        answerY = findViewById(R.id.answerY)
        answerZ = findViewById(R.id.answerZ)

    }



}