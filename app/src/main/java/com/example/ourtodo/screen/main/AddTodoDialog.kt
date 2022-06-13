package com.example.ourtodo.screen.main


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.DialogFragment
import com.example.ourtodo.R
import com.example.ourtodo.databinding.DialogAddTodoBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class AddTodoDialog() : DialogFragment() {

    private lateinit var binding: DialogAddTodoBinding

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

        val adapter = activity?.let { ArrayAdapter.createFromResource(it, R.array.tag, android.R.layout.simple_spinner_item) }

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