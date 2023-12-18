package com.example.capstoneootd.data.response

import com.google.gson.annotations.SerializedName

data class ResponseRegister(

	@field:SerializedName("success")
	val success: Boolean? = null,

	@field:SerializedName("message")
	val message: String? = null
)
