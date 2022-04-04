package com.example.ourtodo.data.repository

import com.example.ourtodo.data.response.Message
import com.google.gson.JsonParser
import retrofit2.Response

object ParseErrorMessage {

    fun parseErrorMessage(response: Response<Message>): String {
        val errorJsonString = response.errorBody()!!.string()

        return JsonParser().parse(errorJsonString)
            .asJsonObject["message"]
            .asString
    }
}