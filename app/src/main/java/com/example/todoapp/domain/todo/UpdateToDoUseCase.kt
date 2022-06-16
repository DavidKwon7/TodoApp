package com.example.todoapp.domain.todo

import com.example.todoapp.data.entity.ToDoEntity
import com.example.todoapp.data.local.repository.TodoRepository
import com.example.todoapp.domain.UseCase

class UpdateToDoUseCase(
    private val todoRepository: TodoRepository
) : UseCase {
    suspend operator fun invoke(toDoEntity: ToDoEntity) {
        return todoRepository.updateToDoItem(toDoEntity)
    }
}