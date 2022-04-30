package com.example.ourtodo.data.retrofit

import com.example.ourtodo.OurToDoApplication
import com.example.ourtodo.data.response.Login
import com.example.ourtodo.data.response.Message
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*
import kotlin.collections.HashMap

interface RetrofitAPI {

    @POST("auth/certification/signup")
    suspend fun signUpCertificationMail(
        @Body email: HashMap<String, Any>
    ): Response<Message>

    @POST("auth/certification/verification/signup")
    suspend fun verifyCertificationMail(
        @Body data: HashMap<String, Any>
    ): Response<Message>

    @POST("/auth/signup")
    suspend fun signup(
        @Body data: HashMap<String, Any>
    ): Response<Message>

    @POST("/auth/login")
    suspend fun login(
        @Body data: HashMap<String, Any>
    ): Response<Login>

    @POST("/auth/refresh")
    suspend fun tokenRefresh(
        @Header("Authorization") accessToken: String,
        @Header("Cookie") refreshToken: String,
    ) : Response<Login>

    @GET("/test/token")
    suspend fun test(
        @Header("Authorization") accessToken: String
    ): Response<Message>
}