package com.example.ourtodo.di

import com.example.ourtodo.data.repository.LoginRepository
import com.example.ourtodo.viewmodel.EmailCertificateViewModel
import com.example.ourtodo.viewmodel.SignUpViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var appModule = module {


    single { LoginRepository(get())}
    single { Dispatchers.IO }
    single { Dispatchers.Main }
}

var viewModelModule = module {

    viewModel { SignUpViewModel() }
    viewModel { EmailCertificateViewModel(get()) }
}