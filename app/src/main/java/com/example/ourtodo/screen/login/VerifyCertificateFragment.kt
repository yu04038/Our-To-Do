package com.example.ourtodo.screen.login

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.CountDownTimer
import android.text.Editable
import android.text.TextWatcher
import android.view.MotionEvent
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
    private var clickable = false

    override fun observeData() = with(binding){
        viewModel.verifyMessage.observe(this@VerifyCertificateFragment, Observer { res ->
            when (res) {
                "인증을 실패했습니다." -> {
                    certificateFailure.visibility = View.VISIBLE
                    certificateFailure.text = "인증번호가 일치하지 않습니다."
                    certificateLayout.setBackgroundResource(R.drawable.email_certificate_button_shape_failure)
                }
                "인증시간이 지났습니다." -> {
                    certificateFailure.visibility = View.VISIBLE
                    certificateFailure2.visibility = View.VISIBLE
                    certificateFailure.text = "인증번호가 만료되었습니다."
                    certificateFailure2.text = "재전송 버튼을 눌러 다시 진행해주세요."
                    certificateLayout.setBackgroundResource(R.drawable.email_certificate_button_shape_failure)
                }
                "인증을 성공했습니다." -> {
                    certificateFailure.visibility = View.INVISIBLE
                    certificateFailure2.visibility = View.INVISIBLE
                    certificateSuccess.visibility = View.VISIBLE
                    certificateSuccess.text = "인증 확인되었습니다."
                    certificateLayout.setBackgroundResource(R.drawable.email_certificate_edittext_shape_valid)
                    goToPassword.setBackgroundResource(R.drawable.email_certificate_button_shape_enabled)
                    goToPassword.setTextColor(Color.parseColor("#333333"))
                    clickable = true
                }
            }
        })
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun initViews() = with(binding){
        super.initViews()

        setTimer()

        certificationCode.setOnFocusChangeListener{ view, b ->
            when(b) {
                true -> certificateLayout.setBackgroundResource(R.drawable.email_certificate_edittext_shape_valid)
                else -> {}
            }
        }

        certificationCode.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0!!.length == 6) {
                    code = p0.toString()
                    data.put("code", code)
                    data.put("email", email)

                    viewModel.verifyCertificationMail(data)
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })

        resend.setOnClickListener {

            certificateFailure.visibility = View.INVISIBLE
            certificateFailure2.visibility = View.INVISIBLE

            certificateLayout.setBackgroundResource(R.drawable.email_certificate_edittext_shape_valid)

            timer.cancel()
            setTimer()

            data.put("email", email)
            viewModel.resendCertificationCode(data)
        }

        goToPassword.setOnClickListener {
            if (clickable) {
                    (activity as SignUpActivity).showFragment(PasswordFragment.newInstance(), PasswordFragment.TAG)
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