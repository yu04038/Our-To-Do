package com.example.ourtodo.data.response


import com.google.gson.annotations.SerializedName

data class todoList(
    @SerializedName("message")
    val message: String,
    @SerializedName("todos")
    val todos: List<Todo>
)