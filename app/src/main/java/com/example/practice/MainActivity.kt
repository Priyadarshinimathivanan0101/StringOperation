package com.example.practice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.lang.Exception

class MainActivity : AppCompatActivity() {
        private lateinit var reverseButton: Button
        private lateinit var splitButton: Button
        private lateinit var appendButton: Button
        private lateinit var splitComma: Button
        private lateinit var resultText: TextView
        private lateinit var result: TextView
        private lateinit var optionButton: Button
        companion object{
            var mode: Int = 1
        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        appendButton = findViewById<Button>(R.id.appendButton)
        reverseButton = findViewById<Button>(R.id.reverseButton)
        splitButton = findViewById<Button>(R.id.splitButton)
        splitComma = findViewById<Button>(R.id.splitcomButton)
        resultText = findViewById<TextView>(R.id.resultText)
        result = findViewById<TextView>(R.id.result)
        optionButton = findViewById(R.id.optionButton)
        appendButton.setOnClickListener {
            var intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("operation", "append")
            startActivityForResult(intent,0)
        }
        reverseButton.setOnClickListener {
            var intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("operation", "reverse")
            startActivityForResult(intent,0)
        }
        splitButton.setOnClickListener {
            var intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("operation", "split")
            startActivityForResult(intent,0)
        }
        splitComma.setOnClickListener {
            var intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("operation", "splitComma")
            startActivityForResult(intent,0)
        }
        optionButton.setOnClickListener {
            displayHome()
            result.text =""
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("RESULT_TEXT", result.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        result.setText(savedInstanceState?.getString("RESULT_TEXT"))
        if(result.text != null && result.text != "") {
            displayResult()
        }
    }

   override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
       appendButton = findViewById<Button>(R.id.appendButton)
       reverseButton = findViewById<Button>(R.id.reverseButton)
       splitButton = findViewById<Button>(R.id.splitButton)
       splitComma = findViewById(R.id.splitcomButton)
       resultText = findViewById<TextView>(R.id.resultText)
       result = findViewById<TextView>(R.id.result)
       optionButton = findViewById(R.id.optionButton)
        if(requestCode == 0) {
                result.text = data?.getStringExtra("data")
        }
        if(mode == 2) {
            displayHome()
        }
       if (mode == 1) {
            displayResult()
       }
    }
    override fun onBackPressed() {
        if(mode == 0) {
            super.onBackPressed()
        }
        displayHome()
        mode = 0
    }
    fun displayHome() {
        appendButton.visibility = View.VISIBLE
        reverseButton.visibility = View.VISIBLE
        splitButton.visibility = View.VISIBLE
        splitComma.visibility = View.VISIBLE
        resultText.visibility = View.GONE
        result.visibility = View.GONE
        optionButton.visibility = View.GONE
    }
    fun displayResult() {
        appendButton.visibility = View.GONE
        reverseButton.visibility = View.GONE
        splitButton.visibility = View.GONE
        splitComma.visibility = View.GONE
        resultText.visibility = View.VISIBLE
        result.visibility = View.VISIBLE
        optionButton.visibility = View.VISIBLE
    }
}