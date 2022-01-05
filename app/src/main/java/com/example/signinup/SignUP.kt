package com.example.signinup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.content.Intent

class SignUP : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        val infoET = listOf<EditText>(
            findViewById(R.id.name_et),
            findViewById(R.id.mobile_et),
            findViewById(R.id.location_et),
            findViewById(R.id.password_et))
        val signOut = findViewById<Button>(R.id.signoutBTN)
        signOut.setOnClickListener {
            val isSorted = DBhelper(applicationContext).storeUser(
                infoET[0].text.toString(),
                infoET[1].text.toString(),
                infoET[2].text.toString(),
                infoET[3].text.toString()
                )
            if(isSorted){
                Toast.makeText(this , "Sign op Seccesssfuly . ", Toast.LENGTH_SHORT).show()
                val intint = Intent(this , Profile::class.java)
                intint.putExtra("caller", "signup")
                intint.putExtra("name ", infoET[0].text.toString())
                intint.putExtra("mobile", infoET[1].text.toString())
                intint.putExtra("location", infoET[2].text.toString())
                startActivity(intent)
            }
            else
                Toast.makeText(this , "Something went wrong ! try later", Toast.LENGTH_SHORT).show()
        }
    }
}
