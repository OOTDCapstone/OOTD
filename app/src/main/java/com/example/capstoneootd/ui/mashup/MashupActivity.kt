package com.example.capstoneootd.ui.mashup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.capstoneootd.R
import com.example.capstoneootd.databinding.ActivityMashupBinding
import com.example.capstoneootd.ui.home.HomeActivity

class MashupActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMashupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMashupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageBack.setOnClickListener {
            startActivity(Intent(this@MashupActivity, HomeActivity::class.java))
        }
    }
}