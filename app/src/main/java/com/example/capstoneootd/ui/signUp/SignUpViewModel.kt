package com.example.capstoneootd.ui.signUp

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.capstoneootd.data.repository.Repository
import com.example.capstoneootd.data.response.SignUpResponse
import com.example.capstoneootd.ui.signIn.SignInActivity
import com.google.gson.Gson
import kotlinx.coroutines.launch
import retrofit2.HttpException

class SignUpViewModel(private val mRepository: Repository): ViewModel() {
    private val _isLoading = MutableLiveData<Boolean>()
        val isLoading : LiveData<Boolean> = _isLoading
    fun toRegister(username: String, email: String, password: String, context: Context){
        _isLoading.value = true
        viewModelScope.launch {
            try {
                val successResponse = mRepository.register(username,email, password)
                val message = successResponse.message
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                _isLoading.value = false
                context.startActivity(Intent(context, SignInActivity::class.java))

            }catch (e: HttpException){
                val error = e.response()?.errorBody()?.string()
                val errorResponse = Gson().fromJson(error, SignUpResponse::class.java)
                Toast.makeText(context,errorResponse.message.toString(), Toast.LENGTH_SHORT).show()
                _isLoading.value = false

            }
        }
    }

}