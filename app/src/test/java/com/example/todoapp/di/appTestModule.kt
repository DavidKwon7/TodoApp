package com.example.todoapp.di

import com.example.todoapp.data.local.repository.TodoRepository
import com.example.todoapp.data.repository.TestToDoRepository
import org.koin.dsl.module

internal val appTestModule = module {


    single<TodoRepository> { TestToDoRepository() }
}
