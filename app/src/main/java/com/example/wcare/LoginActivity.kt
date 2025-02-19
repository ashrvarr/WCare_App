package com.example.wcare

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

            val signUpBtn = findViewById<Button>(R.id.signUpBtn)
            signUpBtn.setOnClickListener {
                    startActivity(Intent(this, RegisterActivity::class.java))
            }

        val edEmail = findViewById<TextInputEditText>(R.id.edEmail)
        val edEmailL = findViewById<TextInputLayout>(R.id.edEmailL)

        edEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(s: Editable) {
                validateEmail(edEmail, edEmailL)
            }

        })


        val edPassword = findViewById<TextInputEditText>(R.id.edPassword)
        val edPasswordL = findViewById<TextInputLayout>(R.id.edPasswordL)

        edPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(s: Editable) {
                validatePassword(edPassword, edPasswordL)
            }

        })

        val logInBtn = findViewById<Button>(R.id.logInBtn)
        logInBtn.setOnClickListener {
            if (validateEmail(edEmail, edEmailL)
                && validatePassword(edPassword, edPasswordL)
            ) {
                Toast.makeText(this, "Success", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Failed", Toast.LENGTH_LONG).show()
            }

        }

        }
    }