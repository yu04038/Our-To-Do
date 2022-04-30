package com.example.ourtodo.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.ourtodo.OurToDoApplication
import com.example.ourtodo.data.repository.LoginRepository
import com.example.ourtodo.data.repository.ParseErrorMessage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Headers
import java.lang.Exception
import java.net.ConnectException

class LoginFragmentViewModel(
    private val loginRepository: LoginRepository,
//    private val parseErrorMessage: ParseErrorMessage
) : BaseViewModel(){

    var errorMessage = MutableLiveData<Boolean>()
    private lateinit var accessToken: String
    private lateinit var refreshToken: String

    fun getLogin(data: HashMap<String, Any>) = viewModelScope.launch {
        try {
            loginRepository.login(data).let { response ->

                if (response.code() == 201) {
                    accessToken = response.body()!!.accessToken
//                    refreshToken = response.headers().values("Set-Cookie")[0].split(";")[0].split("=")[1]
                    refreshToken = response.headers().values("Set-Cookie")[0]
                    Log.e("refresh", refreshToken)
                    Log.e("access", accessToken)
                    OurToDoApplication.prefs.setString("accessToken", accessToken)
                    OurToDoApplication.prefs.setString("refreshToken", refreshToken)

                    errorMessage.value = true
                } else {
                    errorMessage.value = false
                }
            }
        } catch (e: ConnectException) {
            e.printStackTrace()
        } catch(e: Exception) {
            e.printStackTrace()
        }
    }
}