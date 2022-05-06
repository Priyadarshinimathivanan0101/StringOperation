package com.example.practice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
        private lateinit var reverseButton: Button
        private lateinit var splitButton: Button
        private lateinit var appendButton: Button
        private lateinit var resultText: TextView
        private lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        appendButton = findViewById<Button>(R.id.appendButton)
        reverseButton = findViewById<Button>(R.id.reverseButton)
        splitButton = findViewById<Button>(R.id.splitButton)
        resultText = findViewById<TextView>(R.id.resultText)
        result = findViewById<TextView>(R.id.result)
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
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("RESULT_TEXT", result.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        result.setText(savedInstanceState?.getString("RESULT_TEXT"))
        if(result.text != "") {
            appendButton.visibility = View.GONE
            reverseButton.visibility = View.GONE
            splitButton.visibility = View.GONE
            resultText.visibility = View.VISIBLE
            result.visibility = View.VISIBLE
        }

    }
   override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
       appendButton = findViewById<Button>(R.id.appendButton)
       reverseButton = findViewById<Button>(R.id.reverseButton)
       splitButton = findViewById<Button>(R.id.splitButton)
       resultText = findViewById<TextView>(R.id.resultText)
       result = findViewById<TextView>(R.id.result)
       appendButton.visibility = View.GONE
       reverseButton.visibility = View.GONE
       splitButton.visibility = View.GONE
       resultText.visibility = View.VISIBLE
       result.visibility = View.VISIBLE
        if(requestCode == 0) {
            result.text = data!!.getStringExtra("data")
        }
    }
}