package com.example.capstoneootd.ui.home.homeUi.home

import android.content.Context
import android.provider.ContactsContract.Data
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.capstoneootd.data.dummydata.Topdummy
import com.example.capstoneootd.data.dummydata.dummydata
import com.example.capstoneootd.data.repository.Repository
import com.example.capstoneootd.data.response.DataSampleResponse
import com.example.capstoneootd.data.response.ImageUrlsByCategory
import com.example.capstoneootd.data.response.SignInResponse
import com.google.gson.Gson
import kotlinx.coroutines.launch
import retrofit2.HttpException

class HomeViewModel(private val mRepository: Repository) : ViewModel()    {
    private val _top = MutableLiveData<List<ImageUrlsByCategory>>()
    val top: LiveData<List<ImageUrlsByCategory>> = _top

    fun getTop(context: Context){
        viewModelScope.launch {
            try {
                val successResponse = mRepository.getTop()
                _top.value = successResponse
            }catch (e: HttpException){
                val eror = e.response()?.errorBody()?.string()
                val erormessage = Gson().fromJson(eror, DataSampleResponse::class.java)
                Toast.makeText(context,erormessage.message.toString(), Toast.LENGTH_SHORT).show()

            }

        }
    }

}