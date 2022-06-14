package com.example.ourtodo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.ourtodo.data.repository.MainRepository
import com.example.ourtodo.data.repository.ParseErrorMessage
import com.example.ourtodo.data.response.Tag
import kotlinx.coroutines.launch

class ToDo2ViewModel(private val mainRepository: MainRepository,
                    private val parseErrorMessage: ParseErrorMessage
) : BaseViewModel() {

}