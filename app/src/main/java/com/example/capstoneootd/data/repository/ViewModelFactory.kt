package com.example.capstoneootd.data.repository

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.capstoneootd.data.di.DataInjection
import com.example.capstoneootd.ui.signIn.SignInViewModel
import com.example.capstoneootd.ui.signUp.SignUpViewModel

class ViewModelFactory private constructor(private val mRepository: Repository): ViewModelProvider.NewInstanceFactory() {

    companion object{
        fun getInstance(context: Context): ViewModelFactory =  ViewModelFactory(DataInjection.ProviderRepository(context))
    }
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SignInViewModel::class.java)) {
            return SignInViewModel(mRepository) as T
        }else if (modelClass.isAssignableFrom(SignUpViewModel::class.java)){
            return SignUpViewModel(mRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}