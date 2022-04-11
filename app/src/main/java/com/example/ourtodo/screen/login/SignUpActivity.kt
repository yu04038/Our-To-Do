package com.example.ourtodo.screen.login

import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.ourtodo.R
import com.example.ourtodo.databinding.ActivitySignUpBinding
import com.example.ourtodo.screen.base.BaseActivity
import com.example.ourtodo.viewmodel.SignUpViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignUpActivity : BaseActivity<SignUpViewModel, ActivitySignUpBinding>() {

    override val viewModel by viewModel<SignUpViewModel>()

    override fun getViewBinding(): ActivitySignUpBinding = ActivitySignUpBinding.inflate(layoutInflater)

    override fun observeData() {

    }

    override fun initViews() = with(binding) {
        super.initViews()
        showFragment(EmailCertificateFragment.newInstance(), EmailCertificateFragment.TAG)
    }

    fun showFragment(fragment: Fragment, tag: String) {
        val findFragment = supportFragmentManager.findFragmentByTag(tag)

        supportFragmentManager.fragments.forEach { fm ->
            supportFragmentManager.beginTransaction().hide(fm).commit()
        }
        findFragment?.let {
            supportFragmentManager.beginTransaction().show(it).commit()
        } ?: kotlin.run {
            supportFragmentManager.beginTransaction()
                .add(R.id.signUpContainer, fragment, tag)
                .commit()
        }
    }

    fun removeFragment(fragment: Fragment, tag: String) {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            remove(fragment)
        }
    }

}