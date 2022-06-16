package com.example.todoapp.domain.todo

import com.example.todoapp.data.entity.ToDoEntity
import com.example.todoapp.data.local.repository.TodoRepository
import com.example.todoapp.domain.UseCase

class DeleteAllToDoItemUseCase(
    private val todoRepository: TodoRepository
) : UseCase {
    suspend operator fun invoke() {
        todoRepository.deleteAll()
    }
}