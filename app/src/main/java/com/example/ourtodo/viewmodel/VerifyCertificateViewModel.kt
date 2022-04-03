package com.example.ourtodo.viewmodel

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.ourtodo.data.repository.LoginRepository
import kotlinx.coroutines.launch

class VerifyCertificateViewModel(
    private val loginRepository: LoginRepository
): BaseViewModel() {

    fun resendCertificationCode(email: HashMap<String, Any>) = viewModelScope.launch {
        loginRepository.signUpCertificationMail(email)
    }

    fun verifyCertificationMail(data: HashMap<String, Any>) = viewModelScope.launch {
        loginRepository.verifyCertificationMail(data)
    }
}