package com.example.ourtodo.data.response


import com.google.gson.annotations.SerializedName

data class tagList(
    @SerializedName("message")
    val message: String,
    @SerializedName("tagList")
    val tagList: List<Tag>
)