package com.example.ourtodo.screen.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.lifecycle.Observer
import com.example.ourtodo.OurToDoApplication
import com.example.ourtodo.R
import com.example.ourtodo.data.response.tagList
import com.example.ourtodo.databinding.FragmentToDoBinding
import com.example.ourtodo.screen.base.BaseFragment
import com.example.ourtodo.screen.login.LoginActivity
import com.example.ourtodo.viewmodel.ToDoViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ToDoFragment : BaseFragment<ToDoViewModel, FragmentToDoBinding>() {

    override fun getViewBinding(): FragmentToDoBinding = FragmentToDoBinding.inflate(layoutInflater)

    private val accessToken = "Bearer " + OurToDoApplication.prefs.getString("accessToken")

    override val viewModel by viewModel<ToDoViewModel>()
    private val tagListName = ArrayList<String>()
    private val tagListColor = ArrayList<String>()
    override fun observeData() {
        viewModel.liveData.observe(this, Observer { message ->
            when(message) {
                null -> {

                }
                else -> {
                    tagListColor.clear()
                    tagListName.clear()

                    for ( i in message) {
                        tagListName.add(i.name)
                        tagListColor.add(i.color)
                    }

                    val bundle1 = bundleOf("tagListColor" to tagListColor)
                    setFragmentResult("request1", bundle1)

                    val bundle2 = bundleOf("tagListName" to tagListName)
                    setFragmentResult("request2", bundle2)

                    Log.e("tagListName", tagListName.toString())
                    Log.e("tagListColor", tagListColor.toString())
                }
            }
        })
    }

    override fun initViews() = with(binding){
        super.initViews()
        val dialog = AddTodoDialog()

        addToDoButton.setOnClickListener {
            viewModel.findTag(accessToken)

            dialog.show(activity!!.supportFragmentManager, TAG)
        }

        addToDoTextView.setOnClickListener {
            dialog.show(activity!!.supportFragmentManager, TAG)
            viewModel.findTag(accessToken)
        }
    }


    companion object {
        const val TAG = "ToDoFragment"
        fun newInstance() = ToDoFragment()
    }

}