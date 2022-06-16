package com.example.todoapp.presentation.list

import com.example.todoapp.data.entity.ToDoEntity

sealed class ToDoListState {

    object Loading : ToDoListState()

    object Fail : ToDoListState()

    data class Success(
        val todoList: List<ToDoEntity>
    ): ToDoListState()

    object Error: ToDoListState()
}