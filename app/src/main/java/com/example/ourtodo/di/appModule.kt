package com.example.ourtodo.di

import com.example.ourtodo.data.repository.LoginRepository
import com.example.ourtodo.data.repository.ParseErrorMessage
import com.example.ourtodo.viewmodel.*
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var appModule = module {


    single { LoginRepository(get(), get())}
    single { Dispatchers.IO }
    single { Dispatchers.Main }
    single { ParseErrorMessage }
}

var viewModelModule = module {

    viewModel { SignUpViewModel() }
    viewModel { ToDoViewModel() }
    viewModel { LoginViewModel() }
    viewModel { MainViewModel(get(), get()) }
    viewModel { PasswordViewModel(get()) }
    viewModel { LoginFragmentViewModel(get())}
    viewModel { EmailCertificateViewModel(get()) }
    viewModel { VerifyCertificateViewModel(get())}
}