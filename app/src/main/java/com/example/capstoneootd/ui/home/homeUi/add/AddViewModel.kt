package com.example.capstoneootd.ui.home.homeUi.add

import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bayustoryapp.data.Utils.Utils
import com.example.bayustoryapp.data.Utils.Utils.reduceFileImage
import com.example.capstoneootd.data.repository.Repository
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.HttpException

class AddViewModel(private val mRepository: Repository) : ViewModel() {

    fun getUpload(imageUri: Uri?, context: Context){
    imageUri?.let { uri ->
        val imageFile = Utils.uriToFile(uri,context).reduceFileImage()
        Log.d("Image File", "showImage: ${imageFile.path}" )
        val requestImageFile = imageFile.asRequestBody("image/jpg".toMediaType())
        val multipartBody = MultipartBody.Part.createFormData(
            "photo",
            imageFile.name,
            requestImageFile
        )
        viewModelScope.launch {
            try {
//                val successResponse = mRepository.getUpload()

            }catch (e:HttpException){

            }
        }

    }
    }
}