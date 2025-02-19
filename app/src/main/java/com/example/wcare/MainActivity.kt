package com.example.wcare

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val displayTxt = findViewById<TextView>(R.id.displayTxt)

        //Checking fetched data after log in
        val currentUser = FirebaseAuth.getInstance().currentUser
        if (currentUser != null){
            val email = currentUser.email
            val userName = currentUser.displayName

            displayTxt.text = ("Email = ${email}\nUsername = ${userName}")
        }

        val logoutBtn = findViewById<Button>(R.id.logoutBtn)
        logoutBtn.setOnClickListener {
            // Logging Out tf
            FirebaseAuth.getInstance().signOut()
            val mainIntent = Intent(this,LoginActivity::class.java)
            mainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(mainIntent)
            finish()
        }

    }
}