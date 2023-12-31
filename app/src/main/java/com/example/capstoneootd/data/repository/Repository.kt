package com.example.capstoneootd.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.example.capstoneootd.data.api.ApiService
import com.example.capstoneootd.data.preferences.DataStorePreference
import com.example.capstoneootd.data.response.ImageUrlsByCategory

class Repository(private val apiService: ApiService, private val preference: DataStorePreference) {
    fun getIsLogin(): LiveData<Boolean> {
        return preference.getLoginSesi().asLiveData()
    }

    suspend fun saveData(token: String, userId : String){
        preference.saveToken(token, userId)
    }
    fun getIdUser(): String{
        return preference.getIdUser()
    }
    suspend fun removeData(){
        preference.removeLoginSession()
    }

    suspend fun getDataUser(userId: String) = apiService.getDataUser(userId)
    suspend fun login(email: String, password: String) = apiService.login(email, password)
    suspend fun register(username: String, email: String, password: String)= apiService.register(username, email, password)

    suspend fun getTop() = apiService.top()


    suspend fun getMiddle() = apiService.middle()

    suspend fun getBottom() = apiService.bottom()

    companion object{
        fun getInstance( apiService: ApiService, preference: DataStorePreference): Repository = Repository(apiService,preference)

    }
}