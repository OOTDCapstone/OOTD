package com.example.capstoneootd.data.preferences

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking


val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "sesi")
class DataStorePreference private constructor(private val dataStore: DataStore<Preferences>){
    private val TOKEN = stringPreferencesKey("token_sesi")
//    private val ID_USER = stringPreferencesKey("user_id")

    fun getLoginSesi(): Flow<Boolean> {
        return dataStore.data.map {preference ->
            Log.d("Preferences_Cheking", preference[TOKEN].toString())
            !preference[TOKEN].equals(null)
        }
    }

    suspend fun saveToken(token: String, userId: String){
        dataStore.edit{pref->
            pref[TOKEN] = token
//            pref[ID_USER] = userId
        }
    }
    suspend fun getToken(): String{
        var token = ""
        dataStore.edit { preference ->
            token = preference[TOKEN].toString() ?: ""
        }
        return token
    }

//    fun getIdUser(): String{
//        var user_id: String = ""
//        runBlocking {
//            dataStore.edit {pref->
//                user_id = pref[ID_USER] ?: ""
//            }
//        }
//        return user_id
//    }

    suspend fun removeLoginSession(){
        dataStore.edit {
            it.remove(TOKEN)
//            it.remove(ID_USER)
        }
    }

    companion object{
        @Volatile
        private var INSTANCE: DataStorePreference? = null
        fun getInstance(dataStore: DataStore<Preferences>):DataStorePreference{
            return INSTANCE ?: synchronized(this) {
                val instance = DataStorePreference(dataStore)
                INSTANCE = instance
                instance
            }
        }
    }
}