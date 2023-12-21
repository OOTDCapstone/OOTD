package com.example.capstoneootd.ui.screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.capstoneootd.R
import com.example.capstoneootd.ui.signIn.SignInActivity

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val logo: ImageView = findViewById(R.id.imSplash)
        logo.alpha = 0f
        logo.animate().setDuration(2000).alpha(1f).withEndAction {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()
        }
    }
}