package com.example.ourtodo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.ourtodo.data.repository.MainRepository
import kotlinx.coroutines.launch


class AddTodoDialogViewModel(private val mainRepository: MainRepository): BaseViewModel() {

    val complete = MutableLiveData<Boolean>()

    fun addTodo(accessToken: String, todo: HashMap<String, Any>) = viewModelScope.launch {
        mainRepository.addTodo(accessToken, todo).let { response ->
            complete.value = response == "ToDo 생성을 완료했습니다."
        }
    }
}