package com.example.todoapp.di

import com.example.todoapp.data.local.repository.TodoRepository
import com.example.todoapp.domain.todo.*
import com.example.todoapp.domain.todo.DeleteAllToDoItemUseCase
import com.example.todoapp.domain.todo.DeleteToDoItemUseCase
import com.example.todoapp.domain.todo.InsertToDoListUseCase
import com.example.todoapp.domain.todo.InsertToDoUseCase
import com.example.todoapp.domain.todo.UpdateToDoUseCase
import com.example.todoapp.presentation.list.ListViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val appModule = module {

    single { Dispatchers.Main }
    single { Dispatchers.IO }

    factory { GetToDoListUseCase(get()) }
    factory { GetToDoItemUseCase(get()) }
    factory { InsertToDoListUseCase(get()) }
    factory { InsertToDoUseCase(get()) }
    factory { DeleteToDoItemUseCase(get()) }
    factory { DeleteAllToDoItemUseCase(get()) }
    factory { UpdateToDoUseCase(get()) }

    viewModel { ListViewModel(get(), get(), get()) }

}