package com.example.ourtodo.screen.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ourtodo.OurToDoApplication
import com.example.ourtodo.R
import com.example.ourtodo.databinding.ActivityMainBinding
import com.example.ourtodo.databinding.ActivitySignUpBinding
import com.example.ourtodo.screen.base.BaseActivity
import com.example.ourtodo.screen.splash.SplashActivity
import com.example.ourtodo.viewmodel.MainViewModel
import com.example.ourtodo.viewmodel.SignUpViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class MainActivity  : BaseActivity<MainViewModel, ActivityMainBinding>(){

    override val viewModel by viewModel<MainViewModel>()

    override fun getViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

    private val accessToken = "Bearer " + OurToDoApplication.prefs.getString("accessToken")

    override fun observeData() {
        viewModel.isUsable.observe(this) {
            when(it) {
                false -> {
                    val intent = Intent(this, SplashActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                true -> { }
            }
        }
    }

    override fun initViews() = with(binding){
        super.initViews()

        viewModel.test(accessToken)

        settingLayout.setOnClickListener {

        }
    }
}