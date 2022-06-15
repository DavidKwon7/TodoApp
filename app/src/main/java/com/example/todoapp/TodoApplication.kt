package com.example.todoapp

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class TodoApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // koin trigger
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@TodoApplication)
            modules()
        }
    }
}