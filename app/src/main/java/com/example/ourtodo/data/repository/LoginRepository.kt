package com.example.ourtodo.data.repository

import android.util.Log
import com.example.ourtodo.data.retrofit.RetrofitInstance
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class LoginRepository(
    private val ioDispatcher: CoroutineDispatcher,
    private val parseErrorMessage: ParseErrorMessage
) {

    suspend fun signUpCertificationMail(email: HashMap<String, Any>): Unit = withContext(ioDispatcher) {

        val response = RetrofitInstance.api.signUpCertificationMail(email)
        Log.e("이메일 인증", response.body().toString())
    }

    suspend fun verifyCertificationMail(data: HashMap<String, Any>) : String = withContext(ioDispatcher) {
        val response = RetrofitInstance.api.verifyCertificationMail(data)

        if (response.isSuccessful) {
            return@withContext response.body()!!.message
        } else {
            return@withContext parseErrorMessage.parseErrorMessage(response)
        }
    }

    suspend fun signup(data: HashMap<String, Any>) : Boolean = withContext(ioDispatcher) {
        val response = RetrofitInstance.api.signup(data)

        if (response.isSuccessful) {
            Log.e("회원가입", response.body().toString())
        } else {
            Log.e("회원가입", parseErrorMessage.parseErrorMessage(response))
        }

        return@withContext response.isSuccessful
    }
}