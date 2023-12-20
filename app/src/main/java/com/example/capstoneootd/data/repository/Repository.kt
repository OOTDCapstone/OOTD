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

    suspend fun saveData(token: String){
        preference.saveToken(token)
    }
    suspend fun removeData(){
        preference.removeLoginSession()
    }
    suspend fun login(email: String, password: String) = apiService.login(email, password)
    suspend fun register(username: String, email: String, password: String)= apiService.register(username, email, password)

    suspend fun getTop() : List<ImageUrlsByCategory>{
       return apiService.top()
    }

    suspend fun middle() = apiService.middle()

    suspend fun bottom() = apiService.bottom()

    companion object{
        fun getInstance( apiService: ApiService, preference: DataStorePreference): Repository = Repository(apiService,preference)

    }
}