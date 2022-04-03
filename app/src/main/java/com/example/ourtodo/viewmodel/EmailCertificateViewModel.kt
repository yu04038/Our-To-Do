package com.example.ourtodo.viewmodel

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.ourtodo.data.repository.LoginRepository
import kotlinx.coroutines.launch
import java.util.*
import kotlin.collections.HashMap

class EmailCertificateViewModel(
    private val loginRepository: LoginRepository
): BaseViewModel() {

    fun getEmailCertificationCode(email: HashMap<String, Any>) = viewModelScope.launch {
        loginRepository.signUpCertificationMail(email)
    }
}