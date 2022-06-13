package com.example.ourtodo.data.response


import com.google.gson.annotations.SerializedName

data class Message(
    @SerializedName("message")
    val message: String
)

data class Login(
    @SerializedName("message")
    val message: String,

    @SerializedName("accessToken")
    val accessToken: String
)
