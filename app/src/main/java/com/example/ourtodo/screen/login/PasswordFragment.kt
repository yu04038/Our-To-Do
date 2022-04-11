package com.example.ourtodo.screen.login

import android.graphics.Color
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.ourtodo.OurToDoApplication
import com.example.ourtodo.R
import com.example.ourtodo.databinding.FragmentPasswordBinding
import com.example.ourtodo.screen.base.BaseFragment
import com.example.ourtodo.viewmodel.PasswordViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PasswordFragment : BaseFragment<PasswordViewModel, FragmentPasswordBinding>() {

    private var firstPassword = ""
    private var secondPassword = ""
    private val data = HashMap<String, Any>()
    private val email = OurToDoApplication.prefs.getString("email")
    private var clickable = false

    override fun getViewBinding(): FragmentPasswordBinding = FragmentPasswordBinding.inflate(layoutInflater)

    override val viewModel by viewModel<PasswordViewModel>()

    override fun observeData() {

        viewModel.completeSignUp.observe(this, Observer {
            when(it) {
                true -> {
                    Log.e("signup", "완료");
                    (activity as SignUpActivity).finish()
                }
                else -> {Toast.makeText(context, "존재하는 이메일입니다.", Toast.LENGTH_SHORT).show()}
            }
        })

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
                secondPassword = passwordVerify.text.toString()
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (passwordVerify.text.toString() != firstPassword) {
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
                data.put("email", email)
                data.put("password", firstPassword)
                data.put("confirmPassword", secondPassword)

//                Log.e("password", "$firstPassword, $secondPassword")

                viewModel.signup(data)
            }
        }
    }

    companion object {
        const val TAG = "PasswordFragment"
        fun newInstance() = PasswordFragment()
    }
}