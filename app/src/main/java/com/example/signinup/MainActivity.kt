package com.example.signinup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val signinbutton = findViewById<Button>(R.id.signoutBTN)
        signinbutton.setOnClickListener {
            startActivity(Intent(this , SignIN::class.java))
            finish()
        }
        val signupbutton = findViewById<Button>(R.id.signoutBTN)
        signupbutton.setOnClickListener {
            startActivity(Intent(this , SignUP::class.java))
            finish()
        }
    }
}