package com.example.ourtodo.data.repository

import android.util.JsonToken
import android.util.Log
import com.example.ourtodo.data.response.Login
import com.example.ourtodo.data.response.tagList
import com.example.ourtodo.data.retrofit.RetrofitInstance
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.Retrofit

class MainRepository(
    private val ioDispatcher: CoroutineDispatcher,
    private val parseErrorMessage: ParseErrorMessage
) {

    suspend fun addTag(accessToken: String, tag: HashMap<String, Any>): String = withContext(ioDispatcher) {

        val response = RetrofitInstance.api.addTag(accessToken, tag)

        if (response.isSuccessful) {
            return@withContext response.body()!!.message
        } else {
            return@withContext parseErrorMessage.parseErrorMessage(response)
        }
    }

    suspend fun findTag(accessToken: String) : tagList = withContext(ioDispatcher) {
        val response = RetrofitInstance.api.findTag(accessToken)

        if (response.isSuccessful) {
            return@withContext response.body()!!
        } else {
            return@withContext response.body()!!
        }
    }

    suspend fun addTodo(accessToken: String, data: HashMap<String, Any>) : String = withContext(ioDispatcher) {
        val response = RetrofitInstance.api.addTodo(accessToken, data)

        if (response.isSuccessful) {
            return@withContext response.body()!!.message
        } else {
            return@withContext parseErrorMessage.parseErrorMessage(response)
        }
    }
//
//    suspend fun login(data: HashMap<String, Any>) = RetrofitInstance.api.login(data)
//
//    suspend fun tokenRefresh(accessToken: String, refreshToken: String) = RetrofitInstance.api.tokenRefresh(accessToken, refreshToken)
//
//    suspend fun test(accessToken: String) = RetrofitInstance.api.test(accessToken)
}