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

    private var tagListColor = ArrayList<String>()
    private var tagListName = ArrayList<String>()

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


        addToDoXButton.setOnClickListener {
            dialog?.dismiss()
        }

        addTag.setOnClickListener {
            val bottomSheetDialog = BottomSheetFragment()
            dialog?.dismiss()

            fragmentManager?.let { it1 -> bottomSheetDialog.show(it1, bottomSheetDialog.tag) }
        }
    }
}