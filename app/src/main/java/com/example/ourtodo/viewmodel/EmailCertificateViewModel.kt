package com.example.ourtodo.viewmodel

import android.os.Bundle
import androidx.lifecycle.viewModelScope
import com.example.ourtodo.data.repository.LoginRepository
import com.example.ourtodo.screen.login.VerifyCertificateFragment
import kotlinx.coroutines.launch
import kotlin.collections.HashMap

class EmailCertificateViewModel(
    private val loginRepository: LoginRepository
): BaseViewModel() {

    fun getEmailCertificationCode(email: HashMap<String, Any>) = viewModelScope.launch {
        loginRepository.signUpCertificationMail(email)
    }
}