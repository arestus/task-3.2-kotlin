package com.example.task_3_kotlin_collections

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout


class MainActivity : AppCompatActivity() {

    private var guessNumber = 13

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val enterTheNumberInput = findViewById<TextInputLayout>(R.id.textInputLayout)
        val acceptButton = findViewById<TextView>(R.id.acceptButton)
        val textResult = findViewById<TextView>(R.id.textResult)




        acceptButton.setOnClickListener {
            val userInput = Integer.valueOf(enterTheNumberInput.editText?.text?.toString())

            when {
                userInput > guessNumber -> {
                    textResult.text = "No :) My number is smaller"
                }
                userInput < guessNumber -> {
                    textResult.text = "No :) My number is bigger"
                }
                userInput == guessNumber -> {
                    textResult.text = "You are right!"
                }
            }
        }
    }

}

