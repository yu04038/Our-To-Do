package com.example.ourtodo.data.retrofit

import com.example.ourtodo.data.response.SignUpCertificateMailResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import java.util.*
import kotlin.collections.HashMap

interface RetrofitAPI {

    @POST("auth/certification/signup")
    suspend fun signUpCertificationMail(
        @Body email: HashMap<String, Any>
    ): Response<SignUpCertificateMailResponse>
}