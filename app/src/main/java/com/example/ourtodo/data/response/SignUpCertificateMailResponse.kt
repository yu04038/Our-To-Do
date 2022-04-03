package com.example.ourtodo.data.response


import com.google.gson.annotations.SerializedName

data class SignUpCertificateMailResponse(
    @SerializedName("message")
    val message: String
)