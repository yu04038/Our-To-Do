package com.example.ourtodo.data.response


import com.google.gson.annotations.SerializedName

data class Tag(
    @SerializedName("color")
    val color: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)