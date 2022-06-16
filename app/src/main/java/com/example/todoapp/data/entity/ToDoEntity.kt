package com.example.todoapp.data.entity

import androidx.room.PrimaryKey

data class ToDoEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val description: String,
    val hasCompleted: Boolean = false
)
