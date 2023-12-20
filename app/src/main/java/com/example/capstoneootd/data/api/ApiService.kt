package com.example.capstoneootd.data.api

import com.example.capstoneootd.data.response.DataSampleResponse
import com.example.capstoneootd.data.response.ImageUrlsByCategory
import com.example.capstoneootd.data.response.ResponseLogin
import com.example.capstoneootd.data.response.ResponseRegister
import com.example.capstoneootd.data.response.SignInResponse
import com.example.capstoneootd.data.response.SignUpResponse
import com.example.capstoneootd.data.response.UserIdResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @FormUrlEncoded
    @POST("register")
    suspend fun register(
        @Field("username") username: String,
        @Field("email") email: String,
        @Field("password") password: String
    ):SignUpResponse

    @FormUrlEncoded
    @POST("login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): SignInResponse

    @GET("user/{userId}")
    suspend fun getDataUser(
        @Path("userId") userId: String
    ): UserIdResponse


    @GET("get_image_urls")
    suspend fun top(
    ) : List<ImageUrlsByCategory>

    @GET("get_image_urls")
    suspend fun middle(
    ): DataSampleResponse

    @GET("get_image_urls")
    suspend fun bottom(): DataSampleResponse
}