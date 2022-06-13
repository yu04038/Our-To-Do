package com.example.ourtodo.data.repository

import com.example.ourtodo.data.response.Login
import com.example.ourtodo.data.response.Message
import com.example.ourtodo.data.response.tagList
import com.google.gson.JsonParser
import retrofit2.Response

object ParseErrorMessage {

    fun parseErrorMessage(response: Response<Message>): String {
        val errorJsonString = response.errorBody()!!.string()

        return JsonParser().parse(errorJsonString)
            .asJsonObject["message"]
            .asString
    }

    fun parseTagMessage(response: Response<tagList>): String {
        val errorJsonString = response.errorBody()!!.string()

        return JsonParser().parse(errorJsonString)
            .asJsonObject["message"]
            .asString
    }

    fun parseLoginErrorMessage(response: Response<Login>): String {
        val errorJsonString = response.errorBody()!!.string()

        return JsonParser().parse(errorJsonString)
            .asJsonObject["message"]
            .asString
    }
}