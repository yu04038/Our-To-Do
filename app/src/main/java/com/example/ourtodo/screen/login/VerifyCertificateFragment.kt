package com.example.ourtodo.screen.login

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.CountDownTimer
import android.text.Editable
import android.text.TextWatcher
import android.view.View
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

    private lateinit var timer: CountDownTimer

    private val data = HashMap<String, Any>()
    private val email = OurToDoApplication.prefs.getString("email")
    private var code = ""
    private var message = ""
    private var clickable = false

    override fun observeData() = with(binding){
        viewModel.verifyMessage.observe(this@VerifyCertificateFragment, Observer { res ->
            if (res != null) {
//                Toast.makeText(context, res, Toast.LENGTH_SHORT).show()
            }
            if (res == "인증을 실패했습니다.") {
                certificateFailure.visibility = View.VISIBLE
                certificateFailure.text = "인증번호가 일치하지 않습니다."
                certificateLayout.setBackgroundResource(R.drawable.email_certificate_button_shape_failure)
            }
            else if (res == "인증시간이 지났습니다.") {
                certificateFailure.visibility = View.VISIBLE
                certificateFailure.text = "인증시간이 지났습니다."
                certificateLayout.setBackgroundResource(R.drawable.email_certificate_button_shape_failure)
            }
        })
    }

    override fun initViews() = with(binding){
        super.initViews()

        setTimer()

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

            certificateFailure.visibility = View.INVISIBLE

            timer.cancel()
            setTimer()

            data.put("email", email)
            viewModel.resendCertificationCode(data)
        }

        goToPassword.setOnClickListener {
            if (clickable) {
                data.put("code", code)
                data.put("email", email)
                viewModel.verifyCertificationMail(data)
            }
        }
    }

    // 인증번호 시간 설정
    private fun setTimer() = with(binding){
        timer = object : CountDownTimer(5 * 60 * 1000, 1000) {
            @SuppressLint("SetTextI18n")
            override fun onTick(p0: Long) {
                val remainingSecond = p0 / 1000
                val minute = (remainingSecond / 60).toString()
                var second = (remainingSecond % 60).toString()

                if (second.length == 1) {
                    second = "0$second"
                }

                certificationTime.text = "0$minute:$second"
            }

            override fun onFinish() {

            }
        }.start()
    }

    companion object {
        const val TAG = "VerifyCertificateFragment"
        fun newInstance() = VerifyCertificateFragment()
    }
}