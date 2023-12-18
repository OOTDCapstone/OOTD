package com.example.capstoneootd.data.api

import com.example.capstoneootd.data.response.ResponseLogin
import com.example.capstoneootd.data.response.ResponseRegister
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {
    @FormUrlEncoded
    @POST("register")
    suspend fun register(
        @Field("username") username: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): ResponseRegister

    @FormUrlEncoded
    @POST("login")
    suspend fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ): ResponseLogin
}