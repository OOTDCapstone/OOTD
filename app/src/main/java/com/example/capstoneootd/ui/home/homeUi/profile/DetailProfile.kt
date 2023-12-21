package com.example.capstoneootd.ui.home.homeUi.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.capstoneootd.R
import com.example.capstoneootd.data.repository.ViewModelFactory
import com.example.capstoneootd.databinding.ActivityDetailProfileBinding
import com.example.capstoneootd.ui.signIn.SignInActivity
import com.example.capstoneootd.ui.signIn.SignInViewModel



class DetailProfile : AppCompatActivity() {
   private lateinit var binding: ActivityDetailProfileBinding
   private lateinit var signInViewModel: SignInViewModel
   private lateinit var profileViewModel: ProfileViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        signInViewModel = obtainViewModel(this@DetailProfile)
        profileViewModel = obtainViewModel1(this@DetailProfile)
        val userId = profileViewModel.getIdUser()
        profileViewModel.getDataUser(userId, context = this)

        profileViewModel.user.observe(this){
            binding.tvNameDetail.text = it.username
            binding.tvEmailDetail.text = it.email
        }
        val imageUrl = "https://i.pinimg.com/originals/c9/e3/e8/c9e3e810a8066b885ca4e882460785fa.jpg"

        Glide.with(this)
            .load(imageUrl)
            .into(binding.ivPotoProfile)

        binding.cardviewLogout.setOnClickListener {
            signInViewModel.removeSession()

            startActivity(Intent(this@DetailProfile, SignInActivity::class.java))
        }
    }
    private fun obtainViewModel(activity: AppCompatActivity): SignInViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory).get(SignInViewModel::class.java)
    }   private fun obtainViewModel1(activity: AppCompatActivity): ProfileViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory).get(ProfileViewModel::class.java)
    }
}