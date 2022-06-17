package com.example.todoapp.presentation.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Job

//todo VM과 연결 해주기
internal abstract class BaseViewModel: ViewModel() {

    abstract fun fetchData(): Job
}