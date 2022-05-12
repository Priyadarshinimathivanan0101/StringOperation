package com.example.practice

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    private lateinit var string1: EditText
    private lateinit var string2: EditText
    private lateinit var operationButton : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val operation = intent.getStringExtra("operation")
        operationButton = findViewById<Button>(R.id.doneButton)
        operationButton.text = operation
        string1 = findViewById<EditText>(R.id.string1)
        string2 = findViewById<EditText>(R.id.string2)
        if(operation.equals("append"))
            string2.visibility = View.VISIBLE
        operationButton.setOnClickListener {
            when (operation.toString()) {
                "append" -> {
                    sendToActivity1("${string1.text} ${string2.text}")
                }
                "reverse" -> {
                    sendToActivity1((string1.text).toString().reversed())
                }
                "split" -> {
                    val chars: List<Char> = string1.text.toList()
                    sendToActivity1(chars.joinToString("  "))
                }
                "splitComma" -> {
                    val chars: List<Char> = string1.text.toList()
                    sendToActivity1(chars.joinToString(","))
                }
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        MainActivity.mode = 2
    }
    fun sendToActivity1(output: String) {
        MainActivity.mode = 1
        var intent = Intent().putExtra("data", output.toString())
        setResult(0, intent)
        finish()
    }
}