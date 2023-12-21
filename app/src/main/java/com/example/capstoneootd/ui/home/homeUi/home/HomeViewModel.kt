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
import com.example.capstoneootd.data.response.BottomRowItem
import com.example.capstoneootd.data.response.ImageUrlsByCategory
import com.example.capstoneootd.data.response.MiddleRowItem
import com.example.capstoneootd.data.response.ResponseSample
import com.example.capstoneootd.data.response.SignInResponse
import com.example.capstoneootd.data.response.TopRowItem
import com.google.gson.Gson
import kotlinx.coroutines.launch
import retrofit2.HttpException

class HomeViewModel(private val mRepository: Repository) : ViewModel()    {
    private val _top = MutableLiveData<List<TopRowItem?>?>()
    val top: LiveData<List<TopRowItem?>?> = _top
    private val _middle = MutableLiveData<List<MiddleRowItem?>?> ()
    val middle: LiveData<List<MiddleRowItem?>?> = _middle
    private val _bottom = MutableLiveData<List<BottomRowItem?>?>()
    val bottom: LiveData<List<BottomRowItem?>?> = _bottom
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading : LiveData<Boolean> = _isLoading


    fun getTop(context: Context){
        _isLoading.value = true
        viewModelScope.launch {
            try {
                val successResponse = mRepository.getTop()
                _top.value = successResponse.imageUrlsByCategory?.topRow
                _isLoading.value = false
            }catch (e: HttpException){
                val eror = e.response()?.errorBody()?.string()
                val erormessage = Gson().fromJson(eror, ResponseSample::class.java)
                Toast.makeText(context,erormessage.toString(), Toast.LENGTH_SHORT).show()
                _isLoading.value = false

            }

        }
    }

    fun getMiddle(context: Context){
        _isLoading.value = true
        viewModelScope.launch {
            try {
                val successResponse = mRepository.getMiddle()
                _middle.value = successResponse.imageUrlsByCategory?.middleRow
                _isLoading.value = false
            }catch (e: HttpException){
                val eror = e.response()?.errorBody()?.string()
                val erormessage = Gson().fromJson(eror, ResponseSample::class.java)
                Toast.makeText(context,erormessage.toString(), Toast.LENGTH_SHORT).show()
                _isLoading.value = false
            }
        }
    }

    fun getBottom(context: Context){
        _isLoading.value = true
        viewModelScope.launch {
            try {
                val successResponse = mRepository.getBottom()
                _bottom.value = successResponse.imageUrlsByCategory?.bottomRow
                _isLoading.value = false
            }catch (e: HttpException){
                val eror = e.response()?.errorBody()?.string()
                val erormessage = Gson().fromJson(eror, ResponseSample::class.java)
                Toast.makeText(context,erormessage.toString(), Toast.LENGTH_SHORT).show()
                _isLoading.value = false
            }
        }
    }

}