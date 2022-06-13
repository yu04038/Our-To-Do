package com.example.ourtodo.screen.main

import android.widget.ArrayAdapter
import com.example.ourtodo.R
import com.example.ourtodo.databinding.FragmentToDoBinding
import com.example.ourtodo.screen.base.BaseFragment
import com.example.ourtodo.viewmodel.ToDoViewModel
import org.koin.androidx.scope.fragmentScope
import org.koin.androidx.viewmodel.ext.android.viewModel

class ToDoFragment : BaseFragment<ToDoViewModel, FragmentToDoBinding>() {

    override fun getViewBinding(): FragmentToDoBinding = FragmentToDoBinding.inflate(layoutInflater)

    override val viewModel by viewModel<ToDoViewModel>()

    override fun observeData() {

    }

    override fun initViews() = with(binding){
        super.initViews()
        val dialog = AddTodoDialog()

        addToDoButton.setOnClickListener {
            dialog.show(activity!!.supportFragmentManager, TAG)
        }

        addToDoTextView.setOnClickListener {
            dialog.show(activity!!.supportFragmentManager, TAG)
        }
    }




    companion object {
        const val TAG = "ToDoFragment"
        fun newInstance() = ToDoFragment()
    }

}