package com.example.ourtodo.screen.main


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import com.example.ourtodo.OurToDoApplication
import com.example.ourtodo.R
import com.example.ourtodo.data.repository.MainRepository
import com.example.ourtodo.databinding.DialogAddTodoBinding
import com.example.ourtodo.screen.login.LoginActivity
import com.example.ourtodo.screen.splash.SplashActivity
import com.example.ourtodo.viewmodel.AddTodoDialogViewModel
import com.example.ourtodo.viewmodel.BottomSheetViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddTodoDialog() : DialogFragment() {

    private lateinit var binding: DialogAddTodoBinding
    val viewModel by viewModel<AddTodoDialogViewModel>()
    private val accessToken = "Bearer " + OurToDoApplication.prefs.getString("accessToken")

    private var tagListColor = ArrayList<String>()
    private var tagListName = ArrayList<String>()

    private var data = HashMap<String, Any>()
    private var position = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DialogAddTodoBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)

        setFragmentResultListener("request1") { key, bundle ->
            tagListColor = bundle.getStringArrayList("tagListColor")!!
        }

        setFragmentResultListener("request2") { key, bundle ->
            tagListName = bundle.getStringArrayList("tagListName")!!
        }
        var adapter = ArrayAdapter(requireContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, tagListName)

        spinnerTag.adapter = adapter

        spinnerTag.onItemSelectedListener = object :AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                position = p2 + 1
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

        addToDoXButton.setOnClickListener {
            todoEditText.text = null
            dialog?.dismiss()
        }

        addTodoOk.setOnClickListener {


            if (todoEditText.text.toString() == "") {
                Toast.makeText(activity, "Todo의 내용이 비어있습니다.", Toast.LENGTH_SHORT).show()
            } else {
                data.put("tagId", position)
                data.put("content", todoEditText.text.toString())

                viewModel.addTodo(accessToken, data)
                viewModel.complete.observe(this@AddTodoDialog, Observer { message ->
                    when (message) {
                        true -> {
                            Toast.makeText(activity, "ToDo 생성을 완료했습니다.", Toast.LENGTH_SHORT)
                                .show()
                            dialog?.dismiss()
                        }
                        false -> {

                        }
                    }
                })
            }

        }

        addTag.setOnClickListener {
            val bottomSheetDialog = BottomSheetFragment()
            dialog?.dismiss()

            fragmentManager?.let { it1 -> bottomSheetDialog.show(it1, bottomSheetDialog.tag) }
        }
    }
}