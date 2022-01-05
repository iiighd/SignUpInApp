package com.example.signinup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignIN : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        val mobileET = findViewById<EditText>(R.id.login_mobile_et)
        val passET = findViewById<EditText>(R.id.login_password_et)
        val signInBTN = findViewById<Button>(R.id.sign_in_btn)
        signInBTN.setOnClickListener {
            val isLoggedin = DBhelper(applicationContext).authenticateUser(
                mobileET.text.toString(), passET.text.toString()            )
            if (isLoggedin){
                val intint = Intent(this , Profile::class.java)
                intint.putExtra("mobile", mobileET.text.toString() )
                startActivity(intint)
                Toast.makeText(this , "Signin sussccefuly ", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this , "wrong mobile or Password , please try later . ", Toast.LENGTH_SHORT).show()
            }
        }

    }
}