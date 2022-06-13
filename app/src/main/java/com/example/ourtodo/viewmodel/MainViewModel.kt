package com.example.ourtodo.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.ourtodo.OurToDoApplication
import com.example.ourtodo.data.repository.LoginRepository
import com.example.ourtodo.data.repository.ParseErrorMessage
import kotlinx.coroutines.launch
import java.lang.Exception
import java.net.ConnectException

class MainViewModel(
    private val loginRepository: LoginRepository,
    private val parseErrorMessage: ParseErrorMessage
) : BaseViewModel() {

    val isUsable = MutableLiveData<Boolean>()

    private val refreshToken = OurToDoApplication.prefs.getString("refreshToken")


    fun test(accessToken: String) = viewModelScope.launch {
        try {
            loginRepository.test(accessToken).let { response ->
                if (response.code() == 401) {
                    Log.e("test", "토큰 만료")
                    tokenRefresh(accessToken, refreshToken)
                } else {
                    Log.e("test", "${"만료 안됨"} ${response.code()}")
                }
            }
        } catch (e: ConnectException) {
            e.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    // access token 이 만료되었을 때, 새롭게 토큰 발급
    private fun tokenRefresh(accessToken: String, refreshToken: String) = viewModelScope.launch {
        try {
            loginRepository.tokenRefresh(accessToken, refreshToken).let { response ->

                if (response.isSuccessful) {
                    Log.e("refresh", response.body()!!.message)
                    OurToDoApplication.prefs.setString("accessToken", response.body()!!.accessToken)
                    isUsable.value = true
                } else {
                    Log.e("refresh", parseErrorMessage.parseLoginErrorMessage(response))
                    isUsable.value = false
                }
            }
        } catch (e: ConnectException) {
            e.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}