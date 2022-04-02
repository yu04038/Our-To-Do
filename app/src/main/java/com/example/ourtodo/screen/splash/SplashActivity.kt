package com.example.ourtodo.screen.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.ourtodo.R
import com.example.ourtodo.screen.login.SignUpActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val signUpButton = findViewById<Button>(R.id.signup_button)
        val loginButton = findViewById<Button>(R.id.login_button)

        signUpButton.setOnClickListener {
            val intent = Intent(this@SplashActivity, SignUpActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}