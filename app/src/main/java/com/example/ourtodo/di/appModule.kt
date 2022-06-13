package com.example.ourtodo.di

import com.example.ourtodo.data.repository.LoginRepository
import com.example.ourtodo.data.repository.MainRepository
import com.example.ourtodo.data.repository.ParseErrorMessage
import com.example.ourtodo.viewmodel.*
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var appModule = module {

    single { MainRepository(get(), get())}
    single { LoginRepository(get(), get())}
    single { Dispatchers.IO }
    single { Dispatchers.Main }
    single { ParseErrorMessage }
}

var viewModelModule = module {

    viewModel { AddTodoDialogViewModel(get()) }
    viewModel { BottomSheetViewModel( get() ) }
    viewModel { SignUpViewModel() }
    viewModel { ToDoViewModel(get(), get()) }
    viewModel { LoginViewModel() }
    viewModel { MainViewModel(get(), get(), get()) }
    viewModel { PasswordViewModel(get()) }
    viewModel { LoginFragmentViewModel(get())}
    viewModel { EmailCertificateViewModel(get()) }
    viewModel { VerifyCertificateViewModel(get())}
}