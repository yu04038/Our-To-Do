package com.example.ourtodo.screen.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.lifecycle.Observer
import com.example.ourtodo.OurToDoApplication
import com.example.ourtodo.R
import com.example.ourtodo.data.response.tagList
import com.example.ourtodo.databinding.FragmentToDo2Binding
import com.example.ourtodo.databinding.FragmentToDoBinding
import com.example.ourtodo.screen.base.BaseFragment
import com.example.ourtodo.screen.login.LoginActivity
import com.example.ourtodo.viewmodel.ToDo2ViewModel
import com.example.ourtodo.viewmodel.ToDoViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ToDo2Fragment : BaseFragment<ToDo2ViewModel, FragmentToDo2Binding>() {

    override fun getViewBinding(): FragmentToDo2Binding = FragmentToDo2Binding.inflate(layoutInflater)

    private val accessToken = "Bearer " + OurToDoApplication.prefs.getString("accessToken")

    override val viewModel by viewModel<ToDo2ViewModel>()

    override fun observeData() {

    }

    override fun initViews() = with(binding){
        super.initViews()

    }


    companion object {
        const val TAG = "ToDo2Fragment"
        fun newInstance() = ToDo2Fragment()
    }

}