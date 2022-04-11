package com.example.ourtodo.data.retrofit

import okhttp3.JavaNetCookieJar
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.CookieManager

object RetrofitInstance {
    private const val BASE_URL = "http://3.37.137.217:8080/"

//    private val okHttpClient = OkHttpClient.Builder()
//        .cookieJar(JavaNetCookieJar(CookieManager()))
//        .build()

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
//            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api : RetrofitAPI by lazy { retrofit.create(RetrofitAPI::class.java) }
}