package com.ultimatelogger.multiplatform.swichablemultipriorityultimatelogger

import com.nhaarman.mockitokotlin2.mock
import com.ultimatelogger.multiplatform.SwitchableMultiPriorityUltimateLogger
import com.ultimatelogger.multiplatform.di.LazyServiceLocator
import com.ultimatelogger.multiplatform.output.SwitchableMultiPriorityLogger
import com.ultimatelogger.multiplatform.tag.provider.string.StringTagProvider
import com.ultimatelogger.multiplatform.tag.provider.throwable.ThrowableTagProvider
import org.junit.After
import org.junit.Before
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module

internal abstract class SwitchableMultiPriorityUltimateLoggerTest {

    protected val mockSwitchableMultiPriorityLogger: SwitchableMultiPriorityLogger = mock()
    protected val mockStringTagProvider: StringTagProvider = mock()
    protected val mockThrowableTagProvider: ThrowableTagProvider = mock()

    protected lateinit var switchableMultiPriorityUltimateLogger: SwitchableMultiPriorityUltimateLogger

    @Before
    fun setUp() {
        val koinApplication = startKoin {
            modules(
                    module {
                        single { mockSwitchableMultiPriorityLogger }
                        single { mockStringTagProvider }
                        single { mockThrowableTagProvider }
                    }
            )
        }

        LazyServiceLocator.koin = koinApplication.koin

        switchableMultiPriorityUltimateLogger = object : SwitchableMultiPriorityUltimateLogger() {}
    }

    @After
    fun tearDown() = stopKoin()
}