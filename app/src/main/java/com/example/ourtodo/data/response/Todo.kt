package com.example.ourtodo.data.response


import com.google.gson.annotations.SerializedName

data class Todo(
    @SerializedName("tagColor")
    val tagColor: String,
    @SerializedName("tagName")
    val tagName: String,
    @SerializedName("todos")
    val todos: List<TodoX>
)