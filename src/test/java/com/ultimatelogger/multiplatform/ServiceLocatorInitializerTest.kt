package com.ultimatelogger.multiplatform

import com.nhaarman.mockitokotlin2.mock
import com.ultimatelogger.multiplatform.di.LazyServiceLocator
import com.ultimatelogger.multiplatform.di.ServiceLocatorInitializer
import com.ultimatelogger.multiplatform.exception.UltimateLoggerNotInitializedException
import com.ultimatelogger.multiplatform.output.MultiPriorityLogger
import org.junit.After
import org.junit.Test
import org.koin.core.context.stopKoin

internal class ServiceLocatorInitializerTest {

    private val mockMultiPriorityLogger: MultiPriorityLogger = mock()

    @After
    fun tearDown() {
        stopKoin()
    }

    @Test
    fun `init starts Koin, so LazyServiceLocator getDependency doesn't throw exception`() {
        ServiceLocatorInitializer.init(mockMultiPriorityLogger)
        LazyServiceLocator.getDependency<String>()
    }

    @Test(expected = UltimateLoggerNotInitializedException::class)
    fun `destroy stops Koin, so LazyServiceLocator getDependency throws exception`() {
        ServiceLocatorInitializer.init(mockMultiPriorityLogger)

        ServiceLocatorInitializer.destroy()

        LazyServiceLocator.getDependency<String>().value
    }
}