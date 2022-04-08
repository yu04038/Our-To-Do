package com.example.ourtodo.screen.login

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ourtodo.R
import com.example.ourtodo.databinding.FragmentPasswordBinding
import com.example.ourtodo.databinding.FragmentVerifyCertificateBinding
import com.example.ourtodo.screen.base.BaseFragment
import com.example.ourtodo.screen.splash.SplashActivity
import com.example.ourtodo.viewmodel.PasswordViewModel
import com.example.ourtodo.viewmodel.VerifyCertificateViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PasswordFragment : BaseFragment<PasswordViewModel, FragmentPasswordBinding>() {

    private var firstPassword = ""
    private var clickable = false

    override fun getViewBinding(): FragmentPasswordBinding = FragmentPasswordBinding.inflate(layoutInflater)

    override val viewModel by viewModel<PasswordViewModel>()

    override fun observeData() {

    }

    override fun initViews() = with(binding){
        super.initViews()

        password.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                firstPassword = p0.toString()
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0!!.length < 8) {
                    passwordLengthFailure.visibility = View.VISIBLE
                    password.setBackgroundResource(R.drawable.email_certificate_button_shape_failure)
                } else {
                    passwordLengthFailure.visibility = View.GONE
                    password.setBackgroundResource(R.drawable.email_certificate_button_shape_enabled)
                }
            }
        })

        passwordVerify.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (passwordVerify.text.toString() != firstPassword) {
                    Log.e("password", "$firstPassword, $p0")
                    passwordVerifyFailure.visibility = View.VISIBLE
                    passwordVerify.setBackgroundResource(R.drawable.email_certificate_button_shape_failure)
                    goToSplash.setBackgroundResource(R.drawable.email_certificate_button_shape_disabled)
                    goToSplash.setTextColor(Color.parseColor("#BFBFBF"))
                    clickable = false
                } else {
                    passwordVerifyFailure.visibility = View.GONE
                    passwordVerify.setBackgroundResource(R.drawable.email_certificate_button_shape_enabled)
                    goToSplash.setBackgroundResource(R.drawable.email_certificate_button_shape_enabled)
                    goToSplash.setTextColor(Color.parseColor("#333333"))
                    clickable = true
                }
            }
        })

        goToSplash.setOnClickListener {
            if (clickable) {
                activity?.let {
                    val intent = Intent(context, SplashActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }

    companion object {
        const val TAG = "PasswordFragment"
        fun newInstance() = PasswordFragment()
    }
}