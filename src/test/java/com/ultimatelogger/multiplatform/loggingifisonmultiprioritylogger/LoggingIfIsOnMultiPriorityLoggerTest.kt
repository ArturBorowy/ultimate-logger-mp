package com.ultimatelogger.multiplatform.loggingifisonmultiprioritylogger

import com.nhaarman.mockitokotlin2.mock
import com.ultimatelogger.multiplatform.UltimateLogger
import com.ultimatelogger.multiplatform.di.LazyServiceLocator
import com.ultimatelogger.multiplatform.output.LoggingIfIsOnMultiPriorityLogger
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module
import org.mockito.Mockito
import org.mockito.verification.VerificationMode

internal abstract class LoggingIfIsOnMultiPriorityLoggerTest(private var callCount: VerificationMode,
                                                             private var shouldLog: Boolean) {

    private val mockUltimateLogger: UltimateLogger = mock()

    private val loggingIfIsOnMultiPriorityLogger = object : LoggingIfIsOnMultiPriorityLogger() {}

    private val givenWithThreadName = true
    private val givenWithFileNameAndLineNum = true
    private val givenWithClassName = true
    private val givenWithMethodName = true
    private val givenMsg = "[]];"
    private val givenThrowable: Throwable = Exception()
    private val givenAny = Any()

    @Before
    open fun setUp() {
        loggingIfIsOnMultiPriorityLogger.shouldLog = shouldLog

        val koinApplication = startKoin {
            modules(
                    module {
                        single { mockUltimateLogger }
                    }
            )
        }

        LazyServiceLocator.koin = koinApplication.koin
    }

    @After
    fun tearDown() = stopKoin()

    @Test
    fun `v(String) called v(String) on mockUltimateLogger callCount times`() {
        loggingIfIsOnMultiPriorityLogger.v(
                givenMsg,
                givenWithThreadName,
                givenWithFileNameAndLineNum,
                givenWithClassName,
                givenWithMethodName
        )

        verifyCalledOnMockUltimateLogger {
            v(givenMsg,
                    givenWithThreadName,
                    givenWithFileNameAndLineNum,
                    givenWithClassName,
                    givenWithMethodName)
        }
    }

    @Test
    fun `v(Throwable) called v(Throwable) on mockUltimateLogger callCount times`() {
        loggingIfIsOnMultiPriorityLogger.v(givenThrowable, givenMsg, givenWithThreadName)

        verifyCalledOnMockUltimateLogger { v(givenThrowable, givenMsg, givenWithThreadName) }
    }

    @Test
    fun `v(AnyT) called v(AnyT) on mockUltimateLogger callCount times`() {
        loggingIfIsOnMultiPriorityLogger.v(
                givenAny,
                givenWithThreadName,
                givenWithFileNameAndLineNum,
                givenWithClassName,
                givenWithMethodName)

        verifyCalledOnMockUltimateLogger {
            v(givenAny,
                    givenWithThreadName,
                    givenWithFileNameAndLineNum,
                    givenWithClassName,
                    givenWithMethodName)
        }
    }

    @Test
    fun `d(String) called d(String) on mockUltimateLogger callCount times`() {
        loggingIfIsOnMultiPriorityLogger.d(
                givenMsg,
                givenWithThreadName,
                givenWithFileNameAndLineNum,
                givenWithClassName,
                givenWithMethodName
        )

        verifyCalledOnMockUltimateLogger {
            d(givenMsg,
                    givenWithThreadName,
                    givenWithFileNameAndLineNum,
                    givenWithClassName,
                    givenWithMethodName)
        }
    }

    @Test
    fun `d(Throwable) called d(Throwable) on mockUltimateLogger callCount times`() {
        loggingIfIsOnMultiPriorityLogger.d(givenThrowable, givenMsg, givenWithThreadName)

        verifyCalledOnMockUltimateLogger { d(givenThrowable, givenMsg, givenWithThreadName) }
    }

    @Test
    fun `d(AnyT) called d(AnyT) on mockUltimateLogger callCount times`() {
        loggingIfIsOnMultiPriorityLogger.d(
                givenAny,
                givenWithThreadName,
                givenWithFileNameAndLineNum,
                givenWithClassName,
                givenWithMethodName)

        verifyCalledOnMockUltimateLogger {
            d(givenAny,
                    givenWithThreadName,
                    givenWithFileNameAndLineNum,
                    givenWithClassName,
                    givenWithMethodName)
        }
    }

    @Test
    fun `i(String) called i(String) on mockUltimateLogger callCount times`() {
        loggingIfIsOnMultiPriorityLogger.i(
                givenMsg,
                givenWithThreadName,
                givenWithFileNameAndLineNum,
                givenWithClassName,
                givenWithMethodName
        )

        verifyCalledOnMockUltimateLogger {
            i(givenMsg,
                    givenWithThreadName,
                    givenWithFileNameAndLineNum,
                    givenWithClassName,
                    givenWithMethodName)
        }
    }

    @Test
    fun `i(Throwable) called i(Throwable) on mockUltimateLogger callCount times`() {
        loggingIfIsOnMultiPriorityLogger.i(givenThrowable, givenMsg, givenWithThreadName)

        verifyCalledOnMockUltimateLogger { i(givenThrowable, givenMsg, givenWithThreadName) }
    }

    @Test
    fun `i(AnyT) called i(AnyT) on mockUltimateLogger callCount times`() {
        loggingIfIsOnMultiPriorityLogger.i(
                givenAny,
                givenWithThreadName,
                givenWithFileNameAndLineNum,
                givenWithClassName,
                givenWithMethodName)

        verifyCalledOnMockUltimateLogger {
            i(givenAny,
                    givenWithThreadName,
                    givenWithFileNameAndLineNum,
                    givenWithClassName,
                    givenWithMethodName)
        }
    }

    @Test
    fun `w(String) called w(String) on mockUltimateLogger callCount times`() {
        loggingIfIsOnMultiPriorityLogger.w(
                givenMsg,
                givenWithThreadName,
                givenWithFileNameAndLineNum,
                givenWithClassName,
                givenWithMethodName
        )

        verifyCalledOnMockUltimateLogger {
            w(givenMsg,
                    givenWithThreadName,
                    givenWithFileNameAndLineNum,
                    givenWithClassName,
                    givenWithMethodName)
        }
    }

    @Test
    fun `w(Throwable) called w(Throwable) on mockUltimateLogger callCount times`() {
        loggingIfIsOnMultiPriorityLogger.w(givenThrowable, givenMsg, givenWithThreadName)

        verifyCalledOnMockUltimateLogger { w(givenThrowable, givenMsg, givenWithThreadName) }
    }

    @Test
    fun `w(AnyT) called w(AnyT) on mockUltimateLogger callCount times`() {
        loggingIfIsOnMultiPriorityLogger.w(
                givenAny,
                givenWithThreadName,
                givenWithFileNameAndLineNum,
                givenWithClassName,
                givenWithMethodName)

        verifyCalledOnMockUltimateLogger {
            w(givenAny,
                    givenWithThreadName,
                    givenWithFileNameAndLineNum,
                    givenWithClassName,
                    givenWithMethodName)
        }
    }

    @Test
    fun `e(String) called e(String) on mockUltimateLogger callCount times`() {
        loggingIfIsOnMultiPriorityLogger.e(
                givenMsg,
                givenWithThreadName,
                givenWithFileNameAndLineNum,
                givenWithClassName,
                givenWithMethodName
        )

        verifyCalledOnMockUltimateLogger {
            e(givenMsg,
                    givenWithThreadName,
                    givenWithFileNameAndLineNum,
                    givenWithClassName,
                    givenWithMethodName)
        }
    }

    @Test
    fun `e(Throwable) called e(Throwable) on mockUltimateLogger callCount times`() {
        loggingIfIsOnMultiPriorityLogger.e(givenThrowable, givenMsg, givenWithThreadName)

        verifyCalledOnMockUltimateLogger { e(givenThrowable, givenMsg, givenWithThreadName) }
    }

    @Test
    fun `e(AnyT) called e(AnyT) on mockUltimateLogger callCount times`() {
        loggingIfIsOnMultiPriorityLogger.e(
                givenAny,
                givenWithThreadName,
                givenWithFileNameAndLineNum,
                givenWithClassName,
                givenWithMethodName)

        verifyCalledOnMockUltimateLogger {
            e(givenAny,
                    givenWithThreadName,
                    givenWithFileNameAndLineNum,
                    givenWithClassName,
                    givenWithMethodName)
        }
    }

    @Test
    fun `wtf(String) called wtf(String) on mockUltimateLogger callCount times`() {
        loggingIfIsOnMultiPriorityLogger.wtf(
                givenMsg,
                givenWithThreadName,
                givenWithFileNameAndLineNum,
                givenWithClassName,
                givenWithMethodName
        )

        verifyCalledOnMockUltimateLogger {
            wtf(givenMsg,
                    givenWithThreadName,
                    givenWithFileNameAndLineNum,
                    givenWithClassName,
                    givenWithMethodName)
        }
    }

    @Test
    fun `wtf(Throwable) called wtf(Throwable) on mockUltimateLogger callCount times`() {
        loggingIfIsOnMultiPriorityLogger.wtf(givenThrowable, givenMsg, givenWithThreadName)

        verifyCalledOnMockUltimateLogger { wtf(givenThrowable, givenMsg, givenWithThreadName) }
    }

    @Test
    fun `wtf(AnyT) called wtf(AnyT) on mockUltimateLogger callCount times`() {
        loggingIfIsOnMultiPriorityLogger.wtf(
                givenAny,
                givenWithThreadName,
                givenWithFileNameAndLineNum,
                givenWithClassName,
                givenWithMethodName)

        verifyCalledOnMockUltimateLogger {
            wtf(givenAny,
                    givenWithThreadName,
                    givenWithFileNameAndLineNum,
                    givenWithClassName,
                    givenWithMethodName)
        }
    }

    private fun verifyCalledOnMockUltimateLogger(block: UltimateLogger.() -> Unit) =
            Mockito.verify(mockUltimateLogger, callCount).block()
}