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


class MultiActivity : AppCompatActivity() {

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

        textScore = findViewById(R.id.textViewScore)
        textLife = findViewById(R.id.textViewLife)
        textTime = findViewById(R.id.textViewTime)

        textQuestion = findViewById(R.id.textViewQuestion)
        editTextAnswer = findViewById(R.id.editTextAnswer)

        buttonOk = findViewById(R.id.buttonOk)
        buttonNext = findViewById(R.id.buttonNext)

        gameContinue()

        buttonOk.setOnClickListener {

            var input = editTextAnswer.text.toString()

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
                    textQuestion.text = "Correct!"
                    Toast.makeText(applicationContext, "NICE!", Toast.LENGTH_LONG).show()
                    textScore.text = userScore.toString()
                }
                else
                {
                    userLife--
                    textQuestion.text = "Incorrect!"
                    Toast.makeText(applicationContext, "Try Again!", Toast.LENGTH_LONG).show()
                    textLife.text = userLife.toString()
                }
            }
        }

        buttonNext.setOnClickListener {
            pauseTimer()
            resetTimer()
            gameContinue()
            editTextAnswer.setText("")

            if (userLife == 0)
            {
                Toast.makeText(applicationContext, "Game Over!", Toast.LENGTH_LONG).show()
                val intent = Intent(this@MultiActivity, ResultActivity::class.java)
                intent.putExtra("Score:", userScore)
                startActivity(intent)
                finish()
            }
            else
            {
                gameContinue()
            }

        }

    }


    private fun gameContinue()
    {
        val number1 = Random.nextInt(0,10)
        val number2 = Random.nextInt(0,10)
        textQuestion.text = "$number1 * $number2"
        correctAnswer = number1 * number2

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
                textQuestion.text = "Sorry Time Is Up!"
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