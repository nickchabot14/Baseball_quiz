package com.chabot.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

lateinit var questionText : TextView
lateinit var answerX : Button
lateinit var answerY : Button
lateinit var answerZ : Button
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun wirewidgets()                                            {
        questionText = findViewById(R.id.questionText)
        answerX = findViewById(R.id.answerX)
        answerY = findViewById(R.id.answerY)
        answerZ = findViewById(R.id.answerZ                                                                                                                                                                                                                                                                                                                                                                                                                                                   )
    }

    data class Questions(
        var t:String, var a1: String, var a2: String, var a3: String, var correct: Int
    )

}