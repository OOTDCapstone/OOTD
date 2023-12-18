package com.example.capstoneootd.ui.home.homeUi.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.capstoneootd.R
import com.example.capstoneootd.data.repository.ViewModelFactory
import com.example.capstoneootd.databinding.ActivityDetailProfileBinding
import com.example.capstoneootd.ui.signIn.SignInActivity
import com.example.capstoneootd.ui.signIn.SignInViewModel

class DetailProfile : AppCompatActivity() {
   private lateinit var binding: ActivityDetailProfileBinding
   private lateinit var signInViewModel: SignInViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        signInViewModel = obtainViewModel(this@DetailProfile)

        binding.cardviewLogout.setOnClickListener {
            signInViewModel.removeSession()

            startActivity(Intent(this@DetailProfile, SignInActivity::class.java))
        }
    }
    private fun obtainViewModel(activity: AppCompatActivity): SignInViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory).get(SignInViewModel::class.java)
    }
}