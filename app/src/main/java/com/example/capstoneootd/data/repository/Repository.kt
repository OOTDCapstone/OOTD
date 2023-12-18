package com.example.capstoneootd.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.example.capstoneootd.data.api.ApiService
import com.example.capstoneootd.data.preferences.DataStorePreference

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
    suspend fun login(username: String, password: String) = apiService.login(username, password)
    suspend fun register(username: String, email: String, password: String)= apiService.register(username, email, password)
    companion object{
        fun getInstance( apiService: ApiService, preference: DataStorePreference): Repository = Repository(apiService,preference)

    }
}