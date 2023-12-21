package com.example.capstoneootd.ui.signIn

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.capstoneootd.data.repository.Repository
import com.example.capstoneootd.data.response.SignInResponse
import com.google.gson.Gson
import kotlinx.coroutines.launch
import retrofit2.HttpException

class SignInViewModel(private val mRepository: Repository): ViewModel() {
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading : LiveData<Boolean> = _isLoading
    fun getLoginSesi(): LiveData<Boolean>{
        return mRepository.getIsLogin()
    }

    fun saveToken(token: String, userId : String){
        viewModelScope.launch {
            mRepository.saveData(token, userId)
        }
    }
    fun loginAuth(email: String, password: String, context: Context) {
        _isLoading.value = true
        viewModelScope.launch {
            try{

                val successResponse = mRepository.login(email, password)
                val message = successResponse.message
                val token = successResponse.loginResults?.token.toString()
                val userId = successResponse.userId.toString()
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                _isLoading.value = false
                saveToken(token, userId)
            }catch (e: HttpException){
                val error = e.response()?.errorBody()?.string()
                val errorResponse = Gson().fromJson(error, SignInResponse::class.java)
                Toast.makeText(context,errorResponse.message.toString(), Toast.LENGTH_SHORT).show()
                _isLoading.value = false
            }
        }
    }
    fun removeSession(){
        viewModelScope.launch {
            mRepository.removeData()
        }
    }

}