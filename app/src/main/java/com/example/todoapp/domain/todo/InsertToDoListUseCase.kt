package com.example.todoapp.domain.todo

import com.example.todoapp.data.entity.ToDoEntity
import com.example.todoapp.data.local.repository.TodoRepository
import com.example.todoapp.domain.UseCase

internal class InsertToDoListUseCase (
    private val todoRepository: TodoRepository
    ) : UseCase {
        suspend operator fun invoke(toDoEntity: List<ToDoEntity>) {
            return todoRepository.insertToDoList(toDoEntity)
        }

}