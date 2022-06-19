package com.example.todoapp.presentation.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.viewModels
import androidx.core.view.isGone
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapp.R
import com.example.todoapp.databinding.ActivityListBinding
import com.example.todoapp.presentation.base.BaseActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

internal class ListActivity : BaseActivity<ListViewModel>(), CoroutineScope {

    override val viewModel: ListViewModel by viewModels()
    private val adapter = ToDoAdapter()

    private lateinit var binding: ActivityListBinding


    // 코루틴 설정
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + Job()

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun initViews(binding: ActivityListBinding) = with(binding) {
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this@ListActivity, LinearLayoutManager.VERTICAL, false)
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
        refreshLayout.isRefreshing = true
    }

    private fun handleSuccessState(state: ToDoListState.Success) = with(binding) {
        refreshLayout.isEnabled = state.todoList.isNotEmpty()
        refreshLayout.isRefreshing = false

        if (state.todoList.isEmpty()) {
            emptyResultTextView.isGone = false
            recyclerView.isGone = true
        } else {
            emptyResultTextView.isGone = true
            recyclerView.isGone = false

        }
    }

}