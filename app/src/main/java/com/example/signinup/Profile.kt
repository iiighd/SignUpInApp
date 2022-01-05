package com.example.signinup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val textView = listOf<TextView>(
            findViewById(R.id.welcome_tv),
            findViewById(R.id.location_tv),
            findViewById(R.id.name_tv)
        )
        if (intent.getStringExtra("caller").equals("signUp")){
            textView[0].text = "Welcome ${intent.getStringExtra("mobile")}"
            textView[1].text = "Welcome ${intent.getStringExtra("location")}"
            textView[2].text = "Welcome ${intent.getStringExtra("name")}"
        }
        else {
            val mobile = intent.getStringExtra("mobile")
            val user = mobile?.let { DBhelper(applicationContext).getUser(it)}
                textView[0].text = "Welcome ${user?.mobile}"
                textView[1].text = "Welcome ${user?.location}"
                textView[2].text = "Welcome ${user?.name}"
            }
        val signOutBTN = findViewById<Button>(R.id.signoutBTN)
        signOutBTN.setOnClickListener {
            startActivity(Intent(this , MainActivity::class.java))
            Toast.makeText(this, "signed out , see you soon ", Toast.LENGTH_SHORT).show()
            finish()
        }
        }
    }
