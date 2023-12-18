package com.example.capstoneootd.data.response

import com.google.gson.annotations.SerializedName

data class ResponseLogin(

	@field:SerializedName("loginResult")
	val loginResult: LoginResult? = null,

	@field:SerializedName("success")
	val success: Boolean? = null,

	@field:SerializedName("message")
	val message: String? = null
)

data class LoginResult(
	@field:SerializedName("username")
	val username: String? = null,

	@field:SerializedName("token")
	val token: String? = null
)
