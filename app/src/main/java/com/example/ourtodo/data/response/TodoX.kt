package com.example.ourtodo.data.response


import com.google.gson.annotations.SerializedName

data class TodoX(
    @SerializedName("content")
    val content: String,
    @SerializedName("id")
    val id: Int
)