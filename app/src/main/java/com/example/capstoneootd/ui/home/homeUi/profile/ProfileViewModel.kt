package com.example.capstoneootd.ui.home.homeUi.profile

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.capstoneootd.data.repository.Repository
import com.example.capstoneootd.data.response.DataSampleResponse
import com.example.capstoneootd.data.response.SignInResponse
import com.example.capstoneootd.data.response.User
import com.example.capstoneootd.data.response.UserIdResponse
import com.google.gson.Gson
import kotlinx.coroutines.launch
import retrofit2.HttpException

class ProfileViewModel(private val mRepository: Repository) : ViewModel() {
    private val _user = MutableLiveData<User>()
    val user : LiveData<User> = _user


    fun getIdUser(): String{
        return mRepository.getIdUser()
    }
    fun getDataUser(userId : String,context: Context){
        viewModelScope.launch {
            try {
                val successResponse = mRepository.getDataUser(userId)
                _user.value = successResponse.user
            }catch (e:HttpException){
                val eror = e.response()?.errorBody()?.string()
                val erormessage = Gson().fromJson(eror, SignInResponse::class.java)
                Toast.makeText(context,erormessage.message.toString(), Toast.LENGTH_SHORT).show()
            }

        }

    }
}