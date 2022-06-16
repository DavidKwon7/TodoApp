package com.example.todoapp.domain.todo

import com.example.todoapp.data.entity.ToDoEntity
import com.example.todoapp.data.local.repository.TodoRepository
import com.example.todoapp.domain.UseCase

class GetToDoItemUseCase(
    private val todoRepository: TodoRepository
) : UseCase {
    suspend operator fun invoke(id: Long): ToDoEntity? {
        return todoRepository.getToDoItem(id = id)
    }
}