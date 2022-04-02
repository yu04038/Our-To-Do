package com.example.ourtodo.screen.login

import com.example.ourtodo.databinding.FragmentEmailCertificateBinding
import com.example.ourtodo.screen.base.BaseFragment
import com.example.ourtodo.viewmodel.EmailCertificateViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class EmailCertificateFragment : BaseFragment<EmailCertificateViewModel, FragmentEmailCertificateBinding>() {

    override fun getViewBinding(): FragmentEmailCertificateBinding = FragmentEmailCertificateBinding.inflate(layoutInflater)

    override val viewModel by viewModel<EmailCertificateViewModel>()

    override fun observeData() {
    }

    override fun initViews() = with(binding) {
        super.initViews()
    }

    companion object {
        const val CERTIFI_NUMBER = "210523"
        const val TAG = "EmailCertificateFragment"
        fun newInstance() = EmailCertificateFragment()
    }

}