package com.example.practice

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private var currQuestion = 0
    private var score = 0
    private lateinit var questionView: TextView
    private lateinit var option1: RadioButton
    private lateinit var option2: RadioButton
    private lateinit var option3: RadioButton
    private lateinit var nextButton: Button
    private lateinit var currQuestions: Question

    private val questions = listOf(
        Question("What is the capital of France?", "Paris", listOf("Paris", "London", "Berlin")),
        Question("What is 2 + 2?", "4", listOf("3", "4", "5")),
        Question(
            "What is the largest planet in our solar system?",
            "Jupiter",
            listOf("Earth", "Mars", "Jupiter")
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        questionView = findViewById(R.id.questionView)
        option1 = findViewById(R.id.option1)
        option2 = findViewById(R.id.option2)
        option3 = findViewById(R.id.option3)
        nextButton = findViewById(R.id.next)
        val finalScore = findViewById<TextView>(R.id.score)
        display()
        nextButton.setOnClickListener {
            var selectedOption = ""
            if (option1.isChecked) {
                selectedOption = option1.text.toString()
            } else if (option2.isChecked) {
                selectedOption = option2.text.toString()
            } else if (option3.isChecked) {
                selectedOption = option3.text.toString()
            }
            if (selectedOption == currQuestions.correctAnswer) {
                score += 1
            }
            currQuestion += 1
            if (currQuestion < questions.size) {
                display()
            } else {
                finalScore.text = "The final score is: $score"
                nextButton.isEnabled=false
            }
        }
    }

    private fun display() {
        if (currQuestion < questions.size) {
            currQuestions = questions[currQuestion]
            questionView.text = currQuestions.question
            option1.apply {
                text = currQuestions.options[0]
                isChecked = false
            }
            option2.apply {
                text = currQuestions.options[1]
                isChecked = false
            }
            option3.apply {
                text = currQuestions.options[2]
                isChecked = false
            }
        }
    }
}
data class Question(val question:String,val correctAnswer:String,val options:List<String>)