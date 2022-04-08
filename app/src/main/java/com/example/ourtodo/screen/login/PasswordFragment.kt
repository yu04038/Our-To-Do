package com.example.ourtodo.screen.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ourtodo.R
import com.example.ourtodo.databinding.FragmentPasswordBinding
import com.example.ourtodo.databinding.FragmentVerifyCertificateBinding
import com.example.ourtodo.screen.base.BaseFragment
import com.example.ourtodo.viewmodel.PasswordViewModel
import com.example.ourtodo.viewmodel.VerifyCertificateViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PasswordFragment : BaseFragment<PasswordViewModel, FragmentPasswordBinding>() {

    override fun getViewBinding(): FragmentPasswordBinding = FragmentPasswordBinding.inflate(layoutInflater)

    override val viewModel by viewModel<PasswordViewModel>()

    override fun observeData() {

    }

    companion object {
        const val TAG = "PasswordFragment"
        fun newInstance() = PasswordFragment()
    }
}