package com.example.todoapp.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.domain.todo.DeleteToDoItemUseCase
import com.example.todoapp.domain.todo.GetToDoItemUseCase
import com.example.todoapp.domain.todo.InsertToDoUseCase
import com.example.todoapp.domain.todo.UpdateToDoUseCase
import com.example.todoapp.presentation.list.DetailMode
import kotlinx.coroutines.launch

internal class DetailViewModel(
    var detailMode: DetailMode,
    var id: Long = -1,
    private val getToDoItemUseCase: GetToDoItemUseCase,
    private val deleteToDoItemUseCase: DeleteToDoItemUseCase,
    private val updateToDoUseCase: UpdateToDoUseCase,
    private val insertToDoUseCase: InsertToDoUseCase
) : ViewModel() {

    private var _toDoDetailLiveData = MutableLiveData<ToDoDetailState>(ToDoDetailState.UnInitialized)
    val toDoDetailLiveData: LiveData<ToDoDetailState> = _toDoDetailLiveData

    fun fetchData() = viewModelScope.launch {
        when(detailMode) {
            DetailMode.WRITE -> {

            }
            DetailMode.DETAIL -> {

            }
        }
    }
}