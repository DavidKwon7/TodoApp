package com.example.todoapp.data.local.repository

import com.example.todoapp.data.entity.ToDoEntity
import com.example.todoapp.data.local.db.dao.ToDoDao
import kotlinx.coroutines.CoroutineDispatcher

class DefaultToDoRepository(
    private val toDoDao: ToDoDao,
    private val ioDispatcher: CoroutineDispatcher
): TodoRepository {

    override suspend fun getToDoLIst(): List<ToDoEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun getToDoItem(id: Long): ToDoEntity? {
        TODO("Not yet implemented")
    }

    override suspend fun insertToDOItem(toDoEntity: ToDoEntity): Long {
        TODO("Not yet implemented")
    }

    override suspend fun insertToDoList(toDoList: List<ToDoEntity>) {
        TODO("Not yet implemented")
    }

    override suspend fun updateToDoItem(toDoEntity: ToDoEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteToDoItem(id: Long) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAll() {
        TODO("Not yet implemented")
    }
}