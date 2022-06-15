package com.example.todoapp

import org.junit.Rule
import org.koin.test.KoinTest
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule

internal class ViewModelTest : KoinTest {

    @get:Rule
    val mockitoRule: MockitoRule = MockitoJUnit.rule()
}