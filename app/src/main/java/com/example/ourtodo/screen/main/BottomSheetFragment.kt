package com.example.ourtodo.screen.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ourtodo.OurToDoApplication
import com.example.ourtodo.R
import com.example.ourtodo.databinding.DialogAddTodoBinding
import com.example.ourtodo.databinding.FragmentBottomSheetBinding
import com.example.ourtodo.viewmodel.BottomSheetViewModel
import com.example.ourtodo.viewmodel.PasswordViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class BottomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentBottomSheetBinding
    val viewModel by viewModel<BottomSheetViewModel>()
    var data = HashMap<String, Any>()
    var color = ""
    private val accessToken = "Bearer " + OurToDoApplication.prefs.getString("accessToken")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)

        val colorList = Array(10) {false}

        tagXButton.setOnClickListener {
            dialog?.dismiss()
        }

        colorPickerRed.setOnClickListener {
            for (i in colorList.indices) {
                if (i == 0) colorList[i]
                else !colorList[i]
            }
            color = "#FFB8B8"
            colorPickerRed.setBackgroundResource(R.drawable.color_picker_red_selected)
            colorPickerOrange.setBackgroundResource(R.drawable.color_picker_orange)
            colorPickerYellow.setBackgroundResource(R.drawable.color_picker_yellow)
            colorPickerGreen.setBackgroundResource(R.drawable.color_picker_green)
            colorPickerDarkGreen.setBackgroundResource(R.drawable.color_picker_darkgreen)
            colorPickerBlue.setBackgroundResource(R.drawable.color_picker_blue)
            colorPickerDarkBlue.setBackgroundResource(R.drawable.color_picker_darkblue)
            colorPickerPurple.setBackgroundResource(R.drawable.color_picker_purple)
            colorPickerPink.setBackgroundResource(R.drawable.color_picker_pink)
            colorPickerGray.setBackgroundResource(R.drawable.color_picker_gray)
        }

        colorPickerOrange.setOnClickListener {
            for (i in colorList.indices) {
                if (i == 1) colorList[i]
                else !colorList[i]
            }
            color = "#FFDBB8"
            colorPickerRed.setBackgroundResource(R.drawable.color_picker_red)
            colorPickerOrange.setBackgroundResource(R.drawable.color_picker_orange_selected)
            colorPickerYellow.setBackgroundResource(R.drawable.color_picker_yellow)
            colorPickerGreen.setBackgroundResource(R.drawable.color_picker_green)
            colorPickerDarkGreen.setBackgroundResource(R.drawable.color_picker_darkgreen)
            colorPickerBlue.setBackgroundResource(R.drawable.color_picker_blue)
            colorPickerDarkBlue.setBackgroundResource(R.drawable.color_picker_darkblue)
            colorPickerPurple.setBackgroundResource(R.drawable.color_picker_purple)
            colorPickerPink.setBackgroundResource(R.drawable.color_picker_pink)
            colorPickerGray.setBackgroundResource(R.drawable.color_picker_gray)
        }

        colorPickerYellow.setOnClickListener {
            for (i in colorList.indices) {
                if (i == 2) colorList[i]
                else !colorList[i]
            }
            color = "#FFFAB8"
            colorPickerRed.setBackgroundResource(R.drawable.color_picker_red)
            colorPickerOrange.setBackgroundResource(R.drawable.color_picker_orange)
            colorPickerYellow.setBackgroundResource(R.drawable.color_picker_yellow_selected)
            colorPickerGreen.setBackgroundResource(R.drawable.color_picker_green)
            colorPickerDarkGreen.setBackgroundResource(R.drawable.color_picker_darkgreen)
            colorPickerBlue.setBackgroundResource(R.drawable.color_picker_blue)
            colorPickerDarkBlue.setBackgroundResource(R.drawable.color_picker_darkblue)
            colorPickerPurple.setBackgroundResource(R.drawable.color_picker_purple)
            colorPickerPink.setBackgroundResource(R.drawable.color_picker_pink)
            colorPickerGray.setBackgroundResource(R.drawable.color_picker_gray)
        }

        colorPickerGreen.setOnClickListener {
            for (i in colorList.indices) {
                if (i == 3) colorList[i]
                else !colorList[i]
            }
            color = "#B8FFC8"
            colorPickerRed.setBackgroundResource(R.drawable.color_picker_red)
            colorPickerOrange.setBackgroundResource(R.drawable.color_picker_orange)
            colorPickerYellow.setBackgroundResource(R.drawable.color_picker_yellow)
            colorPickerGreen.setBackgroundResource(R.drawable.color_picker_green_selected)
            colorPickerDarkGreen.setBackgroundResource(R.drawable.color_picker_darkgreen)
            colorPickerBlue.setBackgroundResource(R.drawable.color_picker_blue)
            colorPickerDarkBlue.setBackgroundResource(R.drawable.color_picker_darkblue)
            colorPickerPurple.setBackgroundResource(R.drawable.color_picker_purple)
            colorPickerPink.setBackgroundResource(R.drawable.color_picker_pink)
            colorPickerGray.setBackgroundResource(R.drawable.color_picker_gray)
        }

        colorPickerDarkGreen.setOnClickListener {
            for (i in colorList.indices) {
                if (i == 4) colorList[i]
                else !colorList[i]
            }
            color = "#9BE8C3"
            colorPickerRed.setBackgroundResource(R.drawable.color_picker_red)
            colorPickerOrange.setBackgroundResource(R.drawable.color_picker_orange)
            colorPickerYellow.setBackgroundResource(R.drawable.color_picker_yellow)
            colorPickerGreen.setBackgroundResource(R.drawable.color_picker_green)
            colorPickerDarkGreen.setBackgroundResource(R.drawable.color_picker_darkgreen_selected)
            colorPickerBlue.setBackgroundResource(R.drawable.color_picker_blue)
            colorPickerDarkBlue.setBackgroundResource(R.drawable.color_picker_darkblue)
            colorPickerPurple.setBackgroundResource(R.drawable.color_picker_purple)
            colorPickerPink.setBackgroundResource(R.drawable.color_picker_pink)
            colorPickerGray.setBackgroundResource(R.drawable.color_picker_gray)
        }

        colorPickerBlue.setOnClickListener {
            for (i in colorList.indices) {
                if (i == 5) colorList[i]
                else !colorList[i]
            }
            color = "#B8E5FF"
            colorPickerRed.setBackgroundResource(R.drawable.color_picker_red)
            colorPickerOrange.setBackgroundResource(R.drawable.color_picker_orange)
            colorPickerYellow.setBackgroundResource(R.drawable.color_picker_yellow)
            colorPickerGreen.setBackgroundResource(R.drawable.color_picker_green)
            colorPickerDarkGreen.setBackgroundResource(R.drawable.color_picker_darkgreen)
            colorPickerBlue.setBackgroundResource(R.drawable.color_picker_blue_selected)
            colorPickerDarkBlue.setBackgroundResource(R.drawable.color_picker_darkblue)
            colorPickerPurple.setBackgroundResource(R.drawable.color_picker_purple)
            colorPickerPink.setBackgroundResource(R.drawable.color_picker_pink)
            colorPickerGray.setBackgroundResource(R.drawable.color_picker_gray)
        }

        colorPickerDarkBlue.setOnClickListener {
            for (i in colorList.indices) {
                if (i == 6) colorList[i]
                else !colorList[i]
            }
            color = "#B8BAFF"
            colorPickerRed.setBackgroundResource(R.drawable.color_picker_red)
            colorPickerOrange.setBackgroundResource(R.drawable.color_picker_orange)
            colorPickerYellow.setBackgroundResource(R.drawable.color_picker_yellow)
            colorPickerGreen.setBackgroundResource(R.drawable.color_picker_green)
            colorPickerDarkGreen.setBackgroundResource(R.drawable.color_picker_darkgreen)
            colorPickerBlue.setBackgroundResource(R.drawable.color_picker_blue)
            colorPickerDarkBlue.setBackgroundResource(R.drawable.color_picker_darkblue_selected)
            colorPickerPurple.setBackgroundResource(R.drawable.color_picker_purple)
            colorPickerPink.setBackgroundResource(R.drawable.color_picker_pink)
            colorPickerGray.setBackgroundResource(R.drawable.color_picker_gray)
        }

        colorPickerPurple.setOnClickListener {
            for (i in colorList.indices) {
                if (i == 7) colorList[i]
                else !colorList[i]
            }
            color = "#EAB8FF"
            colorPickerRed.setBackgroundResource(R.drawable.color_picker_red)
            colorPickerOrange.setBackgroundResource(R.drawable.color_picker_orange)
            colorPickerYellow.setBackgroundResource(R.drawable.color_picker_yellow)
            colorPickerGreen.setBackgroundResource(R.drawable.color_picker_green)
            colorPickerDarkGreen.setBackgroundResource(R.drawable.color_picker_darkgreen)
            colorPickerBlue.setBackgroundResource(R.drawable.color_picker_blue)
            colorPickerDarkBlue.setBackgroundResource(R.drawable.color_picker_darkblue)
            colorPickerPurple.setBackgroundResource(R.drawable.color_picker_purple_selected)
            colorPickerPink.setBackgroundResource(R.drawable.color_picker_pink)
            colorPickerGray.setBackgroundResource(R.drawable.color_picker_gray)
        }

        colorPickerPink.setOnClickListener {
            for (i in colorList.indices) {
                if (i == 8) colorList[i]
                else !colorList[i]
            }
            color = "#FFB8DF"
            colorPickerRed.setBackgroundResource(R.drawable.color_picker_red)
            colorPickerOrange.setBackgroundResource(R.drawable.color_picker_orange)
            colorPickerYellow.setBackgroundResource(R.drawable.color_picker_yellow)
            colorPickerGreen.setBackgroundResource(R.drawable.color_picker_green)
            colorPickerDarkGreen.setBackgroundResource(R.drawable.color_picker_darkgreen)
            colorPickerBlue.setBackgroundResource(R.drawable.color_picker_blue)
            colorPickerDarkBlue.setBackgroundResource(R.drawable.color_picker_darkblue)
            colorPickerPurple.setBackgroundResource(R.drawable.color_picker_purple)
            colorPickerPink.setBackgroundResource(R.drawable.color_picker_pink_selected)
            colorPickerGray.setBackgroundResource(R.drawable.color_picker_gray)
        }

        colorPickerGray.setOnClickListener {
            for (i in colorList.indices) {
                if (i == 9) colorList[i]
                else !colorList[i]
            }
            color = "#C4C4C4"
            colorPickerRed.setBackgroundResource(R.drawable.color_picker_red)
            colorPickerOrange.setBackgroundResource(R.drawable.color_picker_orange)
            colorPickerYellow.setBackgroundResource(R.drawable.color_picker_yellow)
            colorPickerGreen.setBackgroundResource(R.drawable.color_picker_green)
            colorPickerDarkGreen.setBackgroundResource(R.drawable.color_picker_darkgreen)
            colorPickerBlue.setBackgroundResource(R.drawable.color_picker_blue)
            colorPickerDarkBlue.setBackgroundResource(R.drawable.color_picker_darkblue)
            colorPickerPurple.setBackgroundResource(R.drawable.color_picker_purple)
            colorPickerPink.setBackgroundResource(R.drawable.color_picker_pink)
            colorPickerGray.setBackgroundResource(R.drawable.color_picker_gray_selected)
        }

        addTagOk.setOnClickListener {
            if (colorList.count { false } != 10) {
                if (tagEditText.text.toString() == "") {
                    Toast.makeText(activity, "태그를 입력해주세요!", Toast.LENGTH_SHORT).show()
                } else {
                    data.put("name", tagEditText.text.toString())
                    data.put("color", color)

                    viewModel.addTag(accessToken, data)

                    viewModel.complete.observe(this@BottomSheetFragment, Observer { message ->
                        when (message) {
                            true -> {
                                Toast.makeText(activity, "태그 생성을 완료했습니다.", Toast.LENGTH_SHORT)
                                    .show()
                                dialog?.dismiss()
                            }
                            false -> {

                            }
                        }
                    })
                }
            } else {
                Toast.makeText(activity, "태그 색깔을 선택해주세요!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}