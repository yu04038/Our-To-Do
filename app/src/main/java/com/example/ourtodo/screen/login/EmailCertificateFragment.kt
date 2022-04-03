package com.example.ourtodo.screen.login

import android.graphics.Color
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import com.example.ourtodo.R
import com.example.ourtodo.databinding.FragmentEmailCertificateBinding
import com.example.ourtodo.screen.base.BaseFragment
import com.example.ourtodo.viewmodel.EmailCertificateViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class EmailCertificateFragment : BaseFragment<EmailCertificateViewModel, FragmentEmailCertificateBinding>() {

    override fun getViewBinding(): FragmentEmailCertificateBinding = FragmentEmailCertificateBinding.inflate(layoutInflater)

    override val viewModel by viewModel<EmailCertificateViewModel>()

    private var clickable = false

    override fun observeData() {
    }

    override fun initViews() = with(binding) {
        super.initViews()

        goToCertification.setOnClickListener {
            if (clickable) {
                Log.e("goToCertification", "클릭")
            }
        }

        emailCertification.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val email = p0.toString()
                val isValid = android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
                if (!isValid) {
                    emailCertification.setBackgroundResource(R.drawable.email_certificate_edittext_shape_not_valid)
                    goToCertification.setBackgroundResource(R.drawable.email_certificate_button_shape_disabled)
                    goToCertification.setTextColor(Color.parseColor("#BFBFBF"))
                    clickable = false
                    warning.visibility = View.VISIBLE
                } else {
                    emailCertification.setBackgroundResource(R.drawable.email_certificate_edittext_shape_valid)
                    goToCertification.setBackgroundResource(R.drawable.email_certificate_button_shape_enabled)
                    goToCertification.setTextColor(Color.parseColor("#333333"))
                    clickable = true
                    warning.visibility = View.INVISIBLE
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
    }

    companion object {
        const val CERTIFI_NUMBER = "210523"
        const val TAG = "EmailCertificateFragment"
        fun newInstance() = EmailCertificateFragment()
    }

}