package com.chabot.quiz

class Quiz(var Questions: List<Questions>) {
    var score = 0
    var index = 0

    fun addquestions(): Boolean {
        return index <= Questions.size
    }

    fun score(x:Int){
        if(x == Questions[index].correct)
            score++
    }

    fun getnextQuestion() : Questions{
        index++
        return Questions[index]
    }
}