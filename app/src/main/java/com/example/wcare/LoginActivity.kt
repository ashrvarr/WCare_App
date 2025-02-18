package com.example.wcare

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

            val signUpBtn = findViewById<Button>(R.id.signUpBtn)
            signUpBtn.setOnClickListener {
                    startActivity(Intent(this, RegisterActivity::class.java))
            }
        }
    }