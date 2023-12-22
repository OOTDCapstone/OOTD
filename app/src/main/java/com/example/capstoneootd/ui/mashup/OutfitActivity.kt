package com.example.capstoneootd.ui.mashup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.capstoneootd.R
import com.example.capstoneootd.databinding.ActivityOutfitBinding

class OutfitActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOutfitBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOutfitBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.saveOutfit.setOnClickListener {
            saveImage()
        }

    }

    private fun saveImage(){

    }
}