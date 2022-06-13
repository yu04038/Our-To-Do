package com.example.ourtodo.screen.login


import android.content.Intent
import android.graphics.Color
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.ourtodo.R
import com.example.ourtodo.databinding.FragmentLoginBinding
import com.example.ourtodo.screen.base.BaseFragment
import com.example.ourtodo.screen.main.MainActivity
import com.example.ourtodo.viewmodel.LoginFragmentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : BaseFragment<LoginFragmentViewModel, FragmentLoginBinding>() {

    private var emailValid = false
    private var passwordValid = false
    private var clickable = false
    private var data = HashMap<String, Any>()
    private lateinit var email: String
    private lateinit var password: String

    override fun getViewBinding(): FragmentLoginBinding = FragmentLoginBinding.inflate(layoutInflater)

    override val viewModel by viewModel<LoginFragmentViewModel>()

    override fun observeData() = with(binding){
        viewModel.errorMessage.observe(this@LoginFragment, Observer { message ->
            when(message) {
                true -> {
                    loginFailure.visibility = View.GONE

                    (activity as LoginActivity).finish()

                    val intent = Intent(activity, MainActivity::class.java)
                    startActivity(intent)
                }
                false -> { loginFailure.visibility = View.VISIBLE }
            }
        })
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
                    isValid()
                }
            }

            override fun afterTextChanged(p0: Editable?) {
                email = emailForm.text.toString()
            }

        })

        passwordForm.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0!!.isNotEmpty()) {
                    passwordForm.setBackgroundResource(R.drawable.email_certificate_edittext_shape_valid)
                    passwordValid = true
                    isValid()
                }
            }

            override fun afterTextChanged(p0: Editable?) {
                password = passwordForm.text.toString()
            }

        })

        loginButton.setOnClickListener {
            if (clickable) {
                data.put("email", email)
                data.put("password", password)
                viewModel.getLogin(data)
            }
        }
    }

    fun isValid() = with(binding){
        clickable = if (emailValid && passwordValid) {
            with(loginButton) {
                setBackgroundResource(R.drawable.email_certificate_button_shape_enabled)
                setTextColor(Color.parseColor("#333333"))
            }
            true
        } else {
            with(loginButton) {
                setBackgroundResource(R.drawable.email_certificate_button_shape_disabled)
                setTextColor(Color.parseColor("#BFBFBF"))
            }
            false
        }
    }

    companion object {
        const val TAG = "LoginFragment"
        fun newInstance() = LoginFragment()
    }
}