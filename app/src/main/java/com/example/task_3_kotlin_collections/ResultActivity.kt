package com.example.task_3_kotlin_collections

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val resultText = intent.getStringExtra("message")
        val resultNumber = intent.getStringExtra("randomNumber")
        val color = intent.getStringExtra("color")


        findViewById<TextView>(R.id.resultTextView).text = resultText

        findViewById<TextView>(R.id.guessNumberView).setTextColor(Color.parseColor("$color"))

        findViewById<TextView>(R.id.guessNumberView).text = resultNumber

    }
}