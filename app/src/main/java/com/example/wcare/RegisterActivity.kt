package com.example.wcare

import android.app.Dialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val loadingDialog = Dialog(this, R.style.DialogCustomeTheme).apply {
            setContentView(R.layout.loading_dialog)
            window!!.setLayout(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            setCancelable(false)
        }
        val logInBtn = findViewById<Button>(R.id.logInBtn)
        logInBtn.setOnClickListener{
            finish()
        }

        val edName = findViewById<TextInputEditText>(R.id.edName)
        val edNameL = findViewById<TextInputLayout>(R.id.edNameL)

        edName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(s: Editable) {
                validateName(edName, edNameL)
            }

        })


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


        val edConPassword = findViewById<TextInputEditText>(R.id.edConPassword)
        val edConPasswordL = findViewById<TextInputLayout>(R.id.edConPasswordL)
        edConPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(s: Editable) {
                validateConPassword(edPassword, edConPassword, edConPasswordL)
            }

        })


        val signUpBtn = findViewById<Button>(R.id.signUpBtn)
        signUpBtn.setOnClickListener {
            if (validateName(edName, edNameL)
                && validateEmail(edEmail, edEmailL)
                && validatePassword(edPassword, edPasswordL)
                && validateConPassword(edPassword, edConPassword, edConPasswordL)
            ) {
                if (isConnected(this)){
                    Toast.makeText(this, "Success", Toast.LENGTH_LONG).show()
                }else{
                    longToastShow("No Internet Connection")
                }
            }
        }
    }
}