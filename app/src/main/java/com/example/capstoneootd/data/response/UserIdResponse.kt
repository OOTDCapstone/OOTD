package com.example.capstoneootd.data.response

import com.google.gson.annotations.SerializedName

data class UserIdResponse(

	@field:SerializedName("success")
	val success: Boolean? = null,

	@field:SerializedName("user")
	val user: User
)

data class User(

	@field:SerializedName("password")
	val password: String? = null,

	@field:SerializedName("userId")
	val userId: String? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("username")
	val username: String? = null
)
