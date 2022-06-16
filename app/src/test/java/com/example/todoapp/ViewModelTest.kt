package com.example.todoapp

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.todoapp.di.appTestModule
import com.example.todoapp.livedata.LiveDataTestObserver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule

// 실험용으로 사용되고 있는 api가 있는 경우 @OptIn(ExperimentalCoroutinesApi..)을 넣어준다.
@OptIn(ExperimentalCoroutinesApi::class)
internal class ViewModelTest : KoinTest {

    @get:Rule
    val mockitoRule: MockitoRule = MockitoJUnit.rule()

    @Mock
    private lateinit var context: Application

    private val dispatcher = TestCoroutineDispatcher()

    @Before
    fun setUp() {
        startKoin {
            androidContext(context)
            modules(appTestModule)
        }
        Dispatchers.setMain(dispatcher = dispatcher)    //Main Dispatcher를 초기화 해줘야 메모리 누수가 발생 ㄴㄴ
    }

    // 테스트가 다 끝난 다음에는..
    @After
    fun tearDown() {
        stopKoin()
        Dispatchers.resetMain()
    }

    protected fun <T> LiveData<T>.test(): LiveDataTestObserver<T> {
        val testObserver = LiveDataTestObserver<T>()
        observeForever(testObserver)
        return testObserver
    }
}