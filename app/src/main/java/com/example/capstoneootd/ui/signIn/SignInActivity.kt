package com.example.capstoneootd.ui.signIn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.capstoneootd.R
import com.example.capstoneootd.data.repository.ViewModelFactory
import com.example.capstoneootd.databinding.ActivitySignInBinding
import com.example.capstoneootd.ui.home.HomeActivity
import com.example.capstoneootd.ui.signUp.SignUpActivity
import com.example.capstoneootd.ui.signUp.SignUpViewModel

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding
    private lateinit var signInViewModel: SignInViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        signInViewModel = obtainViewModel(this@SignInActivity)
        signInViewModel.isLoading.observe(this) {
            showLoading(it)
        }

        signInViewModel.getLoginSesi().observe(this) { login ->
            if (login.equals(true)) {
                startActivity(Intent(this@SignInActivity, HomeActivity::class.java))
            }
        }

        binding.btnSignIn.setOnClickListener {
            val username = binding.edLogin.text.toString()
            val password = binding.edPassword.text.toString()
            signInViewModel.loginAuth(username,password, this)
        }
        binding.tvDaftar.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

    }
    private fun showLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }

    private fun obtainViewModel(activity: AppCompatActivity): SignInViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory).get(SignInViewModel::class.java)
    }
}