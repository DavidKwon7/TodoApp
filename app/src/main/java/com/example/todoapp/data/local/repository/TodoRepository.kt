package com.example.todoapp.data.local.repository

import com.example.todoapp.data.entity.ToDoEntity

interface TodoRepository {

    suspend fun getToDoLIst(): List<ToDoEntity>
    suspend fun getToDoItem(id:Long): ToDoEntity?

    suspend fun insertToDOItem(toDoEntity: ToDoEntity): Long
    suspend fun insertToDoList(toDoList: List<ToDoEntity>)

    suspend fun updateToDoItem(toDoEntity: ToDoEntity)

    suspend fun deleteToDoItem(id: Long)
    suspend fun deleteAll()
}