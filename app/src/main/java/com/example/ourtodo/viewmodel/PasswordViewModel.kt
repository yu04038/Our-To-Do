package com.example.ourtodo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.ourtodo.data.repository.LoginRepository
import kotlinx.coroutines.launch

class PasswordViewModel(
    private val loginRepository: LoginRepository
): BaseViewModel() {

    var completeSignUp = MutableLiveData<Boolean>()

    fun signup(data: HashMap<String, Any>) = viewModelScope.launch {
        val complete = loginRepository.signup(data)

        completeSignUp.value = complete
    }
}