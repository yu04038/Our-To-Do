package com.example.ourtodo.screen.login


import android.graphics.Color
import android.text.Editable
import android.text.TextWatcher
import androidx.core.widget.addTextChangedListener
import com.example.ourtodo.R
import com.example.ourtodo.databinding.FragmentLoginBinding
import com.example.ourtodo.screen.base.BaseFragment
import com.example.ourtodo.viewmodel.LoginFragmentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : BaseFragment<LoginFragmentViewModel, FragmentLoginBinding>() {

    private var emailValid = false
    private var passwordValid = false

    override fun getViewBinding(): FragmentLoginBinding = FragmentLoginBinding.inflate(layoutInflater)

    override val viewModel by viewModel<LoginFragmentViewModel>()

    override fun observeData() {
    }

    override fun initViews() = with(binding){
        super.initViews()

        emailForm.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0!!.isNotEmpty()) {
                    emailForm.setBackgroundResource(R.drawable.email_certificate_edittext_shape_valid)
                    emailValid = true
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })

        passwordForm.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0!!.isNotEmpty()) {
                    passwordForm.setBackgroundResource(R.drawable.email_certificate_edittext_shape_valid)
                    passwordValid = true
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })

        if (emailValid && passwordValid) {
            loginButton.setBackgroundResource(R.drawable.email_certificate_button_shape_enabled)
            loginButton.setBackgroundColor(Color.BLACK)
        }
    }

    companion object {
        const val TAG = "LoginFragment"
        fun newInstance() = LoginFragment()
    }
}