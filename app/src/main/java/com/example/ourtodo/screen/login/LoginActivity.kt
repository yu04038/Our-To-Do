package com.example.ourtodo.screen.login


import androidx.fragment.app.Fragment
import com.example.ourtodo.R
import com.example.ourtodo.databinding.ActivityLoginBinding
import com.example.ourtodo.screen.base.BaseActivity
import com.example.ourtodo.viewmodel.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity() : BaseActivity<LoginViewModel, ActivityLoginBinding>() {

    override val viewModel by viewModel<LoginViewModel>()

    override fun getViewBinding(): ActivityLoginBinding = ActivityLoginBinding.inflate(layoutInflater)

    override fun observeData() {

    }

    override fun initViews() = with(binding) {
        super.initViews()
        showFragment(LoginFragment.newInstance(), LoginFragment.TAG)
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
                .add(R.id.loginContainer, fragment, tag)
                .commit()
        }
    }

}