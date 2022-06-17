package com.example.todoapp.presentation.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.viewModels
import com.example.todoapp.R
import com.example.todoapp.databinding.ActivityMainBinding
import com.example.todoapp.presentation.base.BaseActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

internal class ListActivity : BaseActivity<ListViewModel>(), CoroutineScope {

    override val viewModel: ListViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    // 코루틴 설정
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + Job()

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun initViews(binding: ActivityMainBinding) = with(binding) {
        // Adapter 연결
        // 새로고침
    }

    override fun observeData() {
        viewModel.toDoListLiveData.observe(this) {
            when(it) {
                is ToDoListState.UnInitialized -> {
                    initViews(binding)
                }
                is ToDoListState.Loading -> {
                    handleLoadingState()
                }
            }
        }
    }

    private fun handleLoadingState() = with(binding) {
        // 코드 입력 (view)
    }

}