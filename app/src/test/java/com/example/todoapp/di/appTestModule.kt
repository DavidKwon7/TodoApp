package com.example.todoapp.di

import com.example.todoapp.data.local.repository.TodoRepository
import com.example.todoapp.data.repository.TestToDoRepository
import com.example.todoapp.domain.todo.*
import com.example.todoapp.viewModel.todo.ListViewModelTest
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val appTestModule = module {

    factory { GetToDoItemUseCase(get()) }
    factory { GetToDoListUseCase(get()) }
    factory { InsertToDoListUseCase(get()) }
    factory { InsertToDoUseCase(get()) }
    factory { UpdateToDoUseCase(get()) }
    factory { DeleteToDoItemUseCase(get()) }
    factory { DeleteAllToDoItemUseCase(get()) }

    single<TodoRepository> { TestToDoRepository() }

}
