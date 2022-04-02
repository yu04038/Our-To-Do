package com.example.ourtodo.di

import com.example.ourtodo.viewmodel.EmailCertificateViewModel
import com.example.ourtodo.viewmodel.SignUpViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.scope.get
import org.koin.dsl.module

val appModule = module {

}

val viewModelModule = module {

    viewModel { EmailCertificateViewModel()}
    viewModel { SignUpViewModel() }
}