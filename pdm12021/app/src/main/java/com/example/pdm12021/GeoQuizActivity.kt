package com.example.pdm12021

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class GeoQuizActivity : AppCompatActivity() {

    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button
    private lateinit var questionTextView: TextView

    private val questionBank = listOf(
        Question(R.string.question_australia, true),//0
        Question(R.string.question_oceans, true),//1
        Question(R.string.question_mideast, false),//2
        Question(R.string.question_africa, false),//3
        Question(R.string.question_americas, true),//4
        Question(R.string.question_asia, true),//5
    )

    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_geo_quiz)

        trueButton = findViewById(R.id.true_botton)
        falseButton = findViewById(R.id.false_botton)
        nextButton = findViewById(R.id.next_botton)
        questionTextView = findViewById(R.id.question_text_view)

        updateQuestion()

        trueButton.setOnClickListener {
            checkAnswer(true)
        }

        falseButton.setOnClickListener {
            checkAnswer(false)
        }

        nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) % questionBank.size
            Log.d("size", questionBank.size.toString())
            Log.d("currentIndex", currentIndex.toString())

            updateQuestion()
        }



    }

    private fun updateQuestion() {
        val questionTextResId = questionBank[currentIndex].textResId
        questionTextView.setText(questionTextResId)
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = questionBank[currentIndex].answer
        val messageResId = if (userAnswer == correctAnswer){
            R.string.correct_toast
        } else {
            R.string.incorrect_toast
        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
            .show()
    }
}