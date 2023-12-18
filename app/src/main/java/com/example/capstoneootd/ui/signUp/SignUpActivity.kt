package com.example.capstoneootd.ui.signUp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.capstoneootd.data.repository.ViewModelFactory
import com.example.capstoneootd.databinding.ActivitySignUpBinding
import com.example.capstoneootd.ui.signIn.SignInActivity

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private lateinit var signUpViewModel: SignUpViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        signUpViewModel = obtainViewModel(this@SignUpActivity)
        signUpViewModel.isLoading.observe(this){
            showLoading(it)
        }

        binding.btnSignup.setOnClickListener {
            val username = binding.edName.text.toString()
            val email = binding.edEmail.text.toString()
            val password = binding.edPassword.text.toString()
            signUpViewModel.toRegister(username,email,password, this)

        }
        binding.tvLogin.setOnClickListener {
            val intent = Intent(this@SignUpActivity, SignInActivity::class.java)
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
    private fun obtainViewModel(activity: AppCompatActivity): SignUpViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory).get(SignUpViewModel::class.java)
    }
}