package com.example.todoapp.presentation.list

import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.R
import com.example.todoapp.data.entity.ToDoEntity
import com.example.todoapp.databinding.ViewholderTodoItemBinding

class ToDoAdapter : RecyclerView.Adapter<ToDoAdapter.ToDoItemViewHolder>() {

    private var toDoList: List<ToDoEntity> = listOf()
    private lateinit var toDoItemClickListener: (ToDoEntity) -> Unit
    private lateinit var toDoCheckListener: (ToDoEntity) -> Unit

    inner class ToDoItemViewHolder(
        private val binding: ViewholderTodoItemBinding,
        val toDoItemClickListener: (ToDoEntity) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindData(data: ToDoEntity) = with(binding) {
            checkBox.text = data.title
            checkToDoComplete(data.hasCompleted)
        }

        fun bindViews(data: ToDoEntity) {
            binding.checkBox.setOnClickListener {
                toDoCheckListener(
                    data.copy(hasCompleted = binding.checkBox.isChecked)
                )
                checkToDoComplete(binding.checkBox.isChecked)
            }
            binding.root.setOnClickListener {
                toDoItemClickListener(data)
            }
        }

        private fun checkToDoComplete(isChecked: Boolean) = with(binding) {
            checkBox.isChecked = isChecked
            container.setBackgroundColor(
                ContextCompat.getColor(root.context,
                if (isChecked){
                    R.color.gray_300
                } else {
                    R.color.white
                })
            )
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoItemViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ToDoItemViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return toDoList.size
    }



}