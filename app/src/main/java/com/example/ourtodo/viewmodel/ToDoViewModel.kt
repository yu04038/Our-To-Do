package com.example.ourtodo.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.ourtodo.data.repository.MainRepository
import com.example.ourtodo.data.repository.ParseErrorMessage
import com.example.ourtodo.data.response.Tag
import kotlinx.coroutines.launch

class ToDoViewModel(private val mainRepository: MainRepository,
                    private val parseErrorMessage: ParseErrorMessage
) : BaseViewModel() {

    val tags = mutableListOf<Pair<String, String>>()
    val liveData = MutableLiveData<List<Tag>>()

    fun findTag(accessToken: String) = viewModelScope.launch {
        mainRepository.findTag(accessToken).let { response ->
            if (response.message == "태그 조회를 완료했습니다.") {
                liveData.value = response.tagList
            }
        }
    }
}