package com.example.task_3_kotlin_collections

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.google.android.material.textfield.TextInputLayout
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    var randomNumber = Random.nextInt(0, 1000)
    private var attemptsQuantity = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val enterTheNumberInput = findViewById<TextInputLayout>(R.id.textInputLayout)
        val acceptButton = findViewById<TextView>(R.id.acceptButton)
        val textResult = findViewById<TextView>(R.id.textResult)

        findViewById<TextView>(R.id.secretNumber).text = randomNumber.toString()

        val successText = "You won! The number is"
        val failureText = "You lost after 12 attempts. The number is"

        var currentAttempts = 0

        val failureColor = "#FF0000"
        val successColor = "#00FF00"



        acceptButton.setOnClickListener {
            val userInput = Integer.valueOf(enterTheNumberInput.editText?.text?.toString())
            currentAttempts += 1

            when {
                currentAttempts > attemptsQuantity -> {
                    val newScreenIntent = Intent(this, ResultActivity::class.java)
                    newScreenIntent( randomNumber, failureColor, failureText)
                }
                userInput > randomNumber -> {
                    textResult.text = "No :) My number is smaller"
                }
                userInput < randomNumber -> {
                    textResult.text = "No :) My number is bigger"
                }
                userInput == randomNumber -> {
                    val newScreenIntent = Intent(this, ResultActivity::class.java)
                    newScreenIntent( randomNumber, successColor,successText)
                }
            }
        }
    }
        private fun newScreenIntent( randomNumber: Int, color : String, message : String){
            val newScreenIntent = Intent(this, ResultActivity::class.java)
            newScreenIntent.putExtra("message", "$message")
            newScreenIntent.putExtra("randomNumber", "$randomNumber")
            newScreenIntent.putExtra("color", color)
            startActivity(newScreenIntent)
        }
    }



