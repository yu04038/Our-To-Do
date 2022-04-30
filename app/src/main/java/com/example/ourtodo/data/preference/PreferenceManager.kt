package com.example.ourtodo.data.preference

import android.content.Context
import android.content.SharedPreferences

class PreferenceManager(context: Context) {

    private val prefs: SharedPreferences = context.getSharedPreferences("pins_android", Context.MODE_PRIVATE)

    fun setString(key: String, str: String) {
        prefs.edit().putString(key, str).apply()
    }

    fun getString(key: String): String {
        return prefs.getString(key, "null").toString()
    }

    fun clear() {
        prefs.edit().clear().apply()
    }

}