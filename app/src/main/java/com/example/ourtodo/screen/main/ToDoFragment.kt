package com.example.ourtodo.screen.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ourtodo.R
import com.example.ourtodo.databinding.FragmentLoginBinding
import com.example.ourtodo.databinding.FragmentToDoBinding
import com.example.ourtodo.screen.base.BaseFragment
import com.example.ourtodo.viewmodel.LoginFragmentViewModel
import com.example.ourtodo.viewmodel.PasswordViewModel
import com.example.ourtodo.viewmodel.ToDoViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ToDoFragment : BaseFragment<ToDoViewModel, FragmentToDoBinding>() {

    override fun getViewBinding(): FragmentToDoBinding = FragmentToDoBinding.inflate(layoutInflater)

    override val viewModel by viewModel<ToDoViewModel>()

    override fun observeData() {

    }

}