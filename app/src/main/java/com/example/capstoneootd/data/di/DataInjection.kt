package com.example.capstoneootd.data.di

import android.content.Context
import com.example.capstoneootd.data.api.ApiConfig
import com.example.capstoneootd.data.preferences.DataStorePreference
import com.example.capstoneootd.data.preferences.dataStore
import com.example.capstoneootd.data.repository.Repository
import kotlinx.coroutines.runBlocking

object DataInjection {
    fun ProviderRepository(context: Context): Repository {
        val preference = DataStorePreference.getInstance(context.dataStore)
        val token = runBlocking { preference.getToken() }
        val apiService = ApiConfig.getApiService(token)
        return Repository.getInstance(apiService, preference)
    }
}