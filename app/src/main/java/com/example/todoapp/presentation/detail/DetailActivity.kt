package com.example.todoapp.presentation.detail

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.core.view.isGone
import com.example.todoapp.databinding.ActivityDetailBinding
import com.example.todoapp.presentation.base.BaseActivity
import com.example.todoapp.presentation.list.DetailMode
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

//todo intent 로 data 받아오기
internal class DetailActivity : BaseActivity<DetailViewModel>() {

    private lateinit var binding: ActivityDetailBinding

    override val viewModel: DetailViewModel by viewModel {
        parametersOf(
            // 받아올 데이터 intent로 가져오기
            intent.getSerializableExtra(DETAIL_MODE_KEY),
            intent.getLongExtra(TODO_ID_KEY, -1)
        )
    }


    companion object {
        const val TODO_ID_KEY = "ToDoId"
        const val DETAIL_MODE_KEY = "DetailMode"

        const val FETCH_REQUEST_CODE = 10

        fun getIntent(context: Context, detailMode: DetailMode) = Intent(
            context, DetailActivity::class.java
        ).apply {
            putExtra(DETAIL_MODE_KEY, detailMode)
        }

        fun getIntent(context: Context, id:Long, detailMode: DetailMode) = Intent(
            context, DetailActivity::class.java
        ).apply {
            putExtra(TODO_ID_KEY, id)
            putExtra(DETAIL_MODE_KEY, detailMode)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setResult(Activity.RESULT_OK)
    }

    override fun observeData() = viewModel.toDoDetailLiveData.observe(this) {
        when(it) {
            is ToDoDetailState.UnInitialized -> {
                initViews(binding)
            }
        }
    }

    private fun initViews(binding: ActivityDetailBinding) = with(binding) {
        titleInput.isEnabled = false
        descriptionInput.isEnabled = false

        deleteButton.isGone = true
        modifyButton.isGone = true
        updateButton.isGone = true

        deleteButton.setOnClickListener {
            viewModel.deleteToDo()
        }
        modifyButton.setOnClickListener {
            viewModel.setModifyMode()
        }
        updateButton.setOnClickListener {
            viewModel.writeToDo(
                title = titleInput.text.toString(),
                description = descriptionInput.text.toString()
            )
        }
    }

}