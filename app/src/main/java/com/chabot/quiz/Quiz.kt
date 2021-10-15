package com.chabot.quiz

class Quiz(var questions: List<question>) {
    var score = 0
    var index = -1

    fun addquestions(): Boolean {
        return index <= questions.size
    }

    fun score(x:Int){
        if(x == questions[index].correct)
            score++
    }

    fun getnextQuestion() : question{
        index++
        return questions[index]
    }
}