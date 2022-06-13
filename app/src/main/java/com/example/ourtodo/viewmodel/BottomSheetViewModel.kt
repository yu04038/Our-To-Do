package com.example.ourtodo.viewmodel

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.ourtodo.data.repository.MainRepository
import kotlinx.coroutines.launch

class BottomSheetViewModel(
    private val mainRepository: MainRepository): BaseViewModel() {

    fun addTag(accessToken: String, tag: HashMap<String, Any>) = viewModelScope.launch {
        mainRepository.addTag(accessToken, tag).let { response ->
            if (response == "태그 생성을 완료했습니다.") {
                Log.e("addTag", response)
            } else {
                Log.e("addTag", response)
            }
        }
    }
}