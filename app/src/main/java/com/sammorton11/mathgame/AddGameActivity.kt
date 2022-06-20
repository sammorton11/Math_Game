package com.sammorton11.mathgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*

import kotlin.random.Random


class AddGameActivity : AppCompatActivity() {

    private lateinit var textScore : TextView
    private lateinit var textLife : TextView
    private lateinit var textTime : TextView
    
    private lateinit var textQuestion : TextView
    private lateinit var editTextAnswer : EditText

    private lateinit var buttonOk : Button
    private lateinit var buttonNext : Button

    private var correctAnswer = 0
    private var userScore = 0
    private var userLife = 3

    private lateinit var timer : CountDownTimer
    private val startTimerInMilliseconds : Long = 60000
    var timeLeftInMillis : Long = startTimerInMilliseconds


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_game)

        //changes title bar name  
        supportActionBar!!.title = "Addition"

        textScore = findViewById(R.id.textViewScoreNumber)
        textLife = findViewById(R.id.textViewLife)
        textTime = findViewById(R.id.textViewTime)

        textQuestion = findViewById(R.id.textViewQuestion)
        editTextAnswer = findViewById(R.id.editTextAnswer)

        buttonOk = findViewById(R.id.buttonOk)
        buttonNext = findViewById(R.id.buttonNext)

        gameContinue()

        editTextAnswer.setOnClickListener {
            editTextAnswer.text.clear()
        }

        buttonOk.setOnClickListener {

            val input = editTextAnswer.text.toString()

            if (input == "")
            {
                Toast.makeText(applicationContext, "Please write your answer or click the next button!", Toast.LENGTH_LONG).show()
            }
            else
            {
                pauseTimer()

                val userAnswer = input.toInt()

                if(userAnswer == correctAnswer)
                {
                    userScore += 10
                    textQuestion.text = getString(R.string.correctAnswerText)
                    Toast.makeText(applicationContext, "NICE!", Toast.LENGTH_LONG).show()
                    textScore.text = userScore.toString()
                }
                else
                {
                    userLife--
                    textQuestion.text = getString(R.string.incorrectAnswerText)
                    Toast.makeText(applicationContext, "Try Again!", Toast.LENGTH_LONG).show()
                    textLife.text = userLife.toString()

                    if(userLife <= 0){
                        results()
                    }
                }
            }
        }

        buttonNext.setOnClickListener {
            pauseTimer()
            resetTimer()
            gameContinue()
            editTextAnswer.text.clear()

            if (userLife <= 0)
            {
                results()
            }
            else
            {
                gameContinue()
            }

        }

    }

    private fun results(){
        Toast.makeText(applicationContext, "Game Over!", Toast.LENGTH_LONG).show()
        val intent = Intent(this@AddGameActivity, ResultActivity::class.java)
        intent.putExtra("Score:", userScore)
        startActivity(intent)
        finish()
    }

    //removed random numbers for testing purposes
    private fun gameContinue()
    {
//        val number1 = Random.nextInt(0,100)
//        val number2 = Random.nextInt(0,100)
        val number1 = 5
        val number2 = 0
        val question = buildString {
            append(number1)
            append(" + ")
            append(number2)
        }

        textQuestion.text = question

        correctAnswer = number1 + number2

        startTimer()

    }

    //TIMER

    private fun startTimer(){

        timer = object : CountDownTimer(timeLeftInMillis,1000)
        {
            override fun onTick(millisUntilFinished: Long)
            {
                timeLeftInMillis = millisUntilFinished
                updateText()
            }

            override fun onFinish()
            {
                pauseTimer()
                resetTimer()
                updateText()
                userLife--
                textLife.text = userLife.toString()
                textQuestion.text = getString(R.string.outOfTimeText)
                results()
            }

        }.start()

    }

    fun updateText()
    {
        val remainingTime : Int = (timeLeftInMillis / 1000).toInt()
        textTime.text = remainingTime.toString()
    }

    fun pauseTimer()
    {
        timer.cancel()
    }

    fun resetTimer()
    {
        timeLeftInMillis = startTimerInMilliseconds
        updateText()
    }

}