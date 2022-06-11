package com.example.ourtodo.screen.main

import com.example.ourtodo.databinding.FragmentToDoBinding
import com.example.ourtodo.screen.base.BaseFragment
import com.example.ourtodo.viewmodel.ToDoViewModel
import org.koin.androidx.scope.fragmentScope
import org.koin.androidx.viewmodel.ext.android.viewModel

class ToDoFragment : BaseFragment<ToDoViewModel, FragmentToDoBinding>() {

    private val context = this

    override fun getViewBinding(): FragmentToDoBinding = FragmentToDoBinding.inflate(layoutInflater)

    override val viewModel by viewModel<ToDoViewModel>()

    override fun observeData() {

    }

    override fun initViews() = with(binding){
        super.initViews()

        addToDoButton.setOnClickListener {
            val dialog = AddTodoDialog()

            dialog.show(activity!!.supportFragmentManager, TAG)
        }

        addToDoTextView.setOnClickListener {
            val dialog = AddTodoDialog()

            fragmentManager?.let { dialog.show(fragmentManager!!, TAG) }
        }
    }

    companion object {
        const val TAG = "ToDoFragment"
        fun newInstance() = ToDoFragment()
    }

}