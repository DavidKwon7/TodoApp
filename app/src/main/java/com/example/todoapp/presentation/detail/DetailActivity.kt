package com.example.todoapp.presentation.detail

import android.content.Context
import android.content.Intent
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

    override fun observeData() {
        TODO("Not yet implemented")
    }

}