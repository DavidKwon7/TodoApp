package com.example.todoapp.domain.todo

import com.example.todoapp.data.entity.ToDoEntity
import com.example.todoapp.data.local.repository.TodoRepository
import com.example.todoapp.domain.UseCase

class DeleteToDoItemUseCase(
    private val todoRepository: TodoRepository
) : UseCase {
    suspend operator fun invoke(id: Long) {
        return todoRepository.deleteToDoItem(id = id)
    }
}