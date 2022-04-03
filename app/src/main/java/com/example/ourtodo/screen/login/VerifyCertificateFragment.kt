package com.example.ourtodo.screen.login

import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.activityViewModels
import com.example.ourtodo.OurToDoApplication
import com.example.ourtodo.databinding.FragmentVerifyCertificateBinding
import com.example.ourtodo.screen.base.BaseFragment
import com.example.ourtodo.viewmodel.EmailCertificateViewModel
import com.example.ourtodo.viewmodel.VerifyCertificateViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class VerifyCertificateFragment() : BaseFragment<VerifyCertificateViewModel, FragmentVerifyCertificateBinding>() {

    override fun getViewBinding(): FragmentVerifyCertificateBinding = FragmentVerifyCertificateBinding.inflate(layoutInflater)

    override val viewModel by viewModel<VerifyCertificateViewModel>()

    private val data = HashMap<String, Any>()
    private val email = OurToDoApplication.prefs.getString("email")
    private var code = ""

    override fun observeData() {
    }

    override fun initViews() = with(binding){
        super.initViews()

        certificationCode.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
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
            data.put("code", code)
            data.put("email", email)
            viewModel.verifyCertificationMail(data)
        }
    }

    companion object {
        const val TAG = "VerifyCertificateFragment"
        fun newInstance() = VerifyCertificateFragment()
    }
}