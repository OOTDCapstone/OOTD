package com.example.capstoneootd.data.response

import com.google.gson.annotations.SerializedName

data class SignInResponse(
	@field:SerializedName("loginResults")
	val loginResults: LoginResults? = null,

	@field:SerializedName("success")
	val success: Boolean? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("userId")
	val userId: String? = null
)
data class LoginResults(
	@field:SerializedName("username")
	val username: String? = null,


	@field:SerializedName("token")
	val token: String? = null
)
