package com.sammorton11.mathgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

 open class MainActivity : AppCompatActivity() {

    private lateinit var addition : Button
    private lateinit var subtraction : Button
    private lateinit var multi : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        addition = findViewById(R.id.buttonAdd)
        subtraction = findViewById(R.id.buttonSub)
        multi = findViewById(R.id.buttonMulti)


        //Buttons
        addition.setOnClickListener {

            val intent = Intent(this@MainActivity, AddGameActivity::class.java)
            startActivity(intent)

        }

        subtraction.setOnClickListener {

            val intent = Intent(this@MainActivity, SubGameActivity::class.java)
            startActivity(intent)

        }

        multi.setOnClickListener {

            val intent = Intent(this@MainActivity, MultiActivity::class.java)
            startActivity(intent)

        }
    }
}