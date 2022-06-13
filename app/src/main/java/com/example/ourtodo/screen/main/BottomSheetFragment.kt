package com.example.ourtodo.screen.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.ourtodo.R
import com.example.ourtodo.databinding.DialogAddTodoBinding
import com.example.ourtodo.databinding.FragmentBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentBottomSheetBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)

        tagXButton.setOnClickListener {
            dialog?.dismiss()
        }

        colorPickerRed.setOnClickListener {
            dialog?.dismiss()
        }

        colorPickerRed.setOnClickListener {
            dialog?.dismiss()
        }

        colorPickerRed.setOnClickListener {
            dialog?.dismiss()
        }

        colorPickerRed.setOnClickListener {
            dialog?.dismiss()
        }

        colorPickerRed.setOnClickListener {
            dialog?.dismiss()
        }

        colorPickerRed.setOnClickListener {
            dialog?.dismiss()
        }
    }
}