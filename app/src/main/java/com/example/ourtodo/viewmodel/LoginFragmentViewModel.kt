package com.example.ourtodo.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.ourtodo.data.repository.LoginRepository
import com.example.ourtodo.data.repository.ParseErrorMessage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import java.net.ConnectException

class LoginFragmentViewModel(
    private val loginRepository: LoginRepository,
//    private val parseErrorMessage: ParseErrorMessage
) : BaseViewModel(){

    var errorMessage = MutableLiveData<Boolean>()

    fun getLogin(data: HashMap<String, Any>) = viewModelScope.launch {
        try {
            loginRepository.login(data).let { response ->

                if (response.code() == 201) {
                    Log.e("message", response.body()!!.message)
                    Log.e("token", response.body()!!.accessToken)
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