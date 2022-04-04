package com.example.ourtodo.screen.login

import android.graphics.Color
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.ourtodo.OurToDoApplication
import com.example.ourtodo.R
import com.example.ourtodo.databinding.FragmentVerifyCertificateBinding
import com.example.ourtodo.screen.base.BaseFragment
import com.example.ourtodo.viewmodel.VerifyCertificateViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class VerifyCertificateFragment() : BaseFragment<VerifyCertificateViewModel, FragmentVerifyCertificateBinding>() {

    override fun getViewBinding(): FragmentVerifyCertificateBinding = FragmentVerifyCertificateBinding.inflate(layoutInflater)

    override val viewModel by viewModel<VerifyCertificateViewModel>()

    private val data = HashMap<String, Any>()
    private val email = OurToDoApplication.prefs.getString("email")
    private var code = ""
    private var clickable = false


    override fun observeData() {
        viewModel.verifyMessage.observe(this, Observer { res ->
            if (res != null) {
                Toast.makeText(context, res, Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun initViews() = with(binding){
        super.initViews()

        certificationCode.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                clickable = if (p0!!.isNotEmpty()) {
                    goToPassword.setBackgroundResource(R.drawable.email_certificate_button_shape_enabled)
                    goToPassword.setTextColor(Color.parseColor("#333333"))
                    true
                } else {
                    goToPassword.setBackgroundResource(R.drawable.email_certificate_button_shape_disabled)
                    goToPassword.setTextColor(Color.parseColor("#BFBFBF"))
                    false
                }
            }

            override fun afterTextChanged(p0: Editable?) {
                code = p0.toString()
            }

        })

        resend.setOnClickListener {
            data.put("email", email)
            viewModel.resendCertificationCode(data)
        }

        goToPassword.setOnClickListener {
            if (clickable) {
                data.put("code", code)
                data.put("email", email)
                viewModel.verifyCertificationMail(data)
            } else {

            }
        }
    }

    companion object {
        const val TAG = "VerifyCertificateFragment"
        fun newInstance() = VerifyCertificateFragment()
    }
}