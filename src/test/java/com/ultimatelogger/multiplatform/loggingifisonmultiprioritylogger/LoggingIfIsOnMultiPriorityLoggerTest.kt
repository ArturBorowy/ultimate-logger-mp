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
                givenWithFileNameAndLineNum,
                givenWithClassName,
                givenWithMethodName
        )

        verifyCalledOnMockUltimateLogger {
            v(givenMsg,
                    givenWithFileNameAndLineNum,
                    givenWithClassName,
                    givenWithMethodName)
        }
    }

    @Test
    fun `v(Throwable) called v(Throwable) on mockUltimateLogger callCount times`() {
        loggingIfIsOnMultiPriorityLogger.v(givenThrowable, givenMsg)

        verifyCalledOnMockUltimateLogger { v(givenThrowable, givenMsg) }
    }

    @Test
    fun `v(AnyT) called v(AnyT) on mockUltimateLogger callCount times`() {
        loggingIfIsOnMultiPriorityLogger.v(
                givenAny,
                givenWithFileNameAndLineNum,
                givenWithClassName,
                givenWithMethodName)

        verifyCalledOnMockUltimateLogger {
            v(givenAny,
                    givenWithFileNameAndLineNum,
                    givenWithClassName,
                    givenWithMethodName)
        }
    }

    @Test
    fun `d(String) called d(String) on mockUltimateLogger callCount times`() {
        loggingIfIsOnMultiPriorityLogger.d(
                givenMsg,
                givenWithFileNameAndLineNum,
                givenWithClassName,
                givenWithMethodName
        )

        verifyCalledOnMockUltimateLogger {
            d(givenMsg,
                    givenWithFileNameAndLineNum,
                    givenWithClassName,
                    givenWithMethodName)
        }
    }

    @Test
    fun `d(Throwable) called d(Throwable) on mockUltimateLogger callCount times`() {
        loggingIfIsOnMultiPriorityLogger.d(givenThrowable, givenMsg)

        verifyCalledOnMockUltimateLogger { d(givenThrowable, givenMsg) }
    }

    @Test
    fun `d(AnyT) called d(AnyT) on mockUltimateLogger callCount times`() {
        loggingIfIsOnMultiPriorityLogger.d(
                givenAny,
                givenWithFileNameAndLineNum,
                givenWithClassName,
                givenWithMethodName)

        verifyCalledOnMockUltimateLogger {
            d(givenAny,
                    givenWithFileNameAndLineNum,
                    givenWithClassName,
                    givenWithMethodName)
        }
    }

    @Test
    fun `i(String) called i(String) on mockUltimateLogger callCount times`() {
        loggingIfIsOnMultiPriorityLogger.i(
                givenMsg,
                givenWithFileNameAndLineNum,
                givenWithClassName,
                givenWithMethodName
        )

        verifyCalledOnMockUltimateLogger {
            i(givenMsg,
                    givenWithFileNameAndLineNum,
                    givenWithClassName,
                    givenWithMethodName)
        }
    }

    @Test
    fun `i(Throwable) called i(Throwable) on mockUltimateLogger callCount times`() {
        loggingIfIsOnMultiPriorityLogger.i(givenThrowable, givenMsg)

        verifyCalledOnMockUltimateLogger { i(givenThrowable, givenMsg) }
    }

    @Test
    fun `i(AnyT) called i(AnyT) on mockUltimateLogger callCount times`() {
        loggingIfIsOnMultiPriorityLogger.i(
                givenAny,
                givenWithFileNameAndLineNum,
                givenWithClassName,
                givenWithMethodName)

        verifyCalledOnMockUltimateLogger {
            i(givenAny,
                    givenWithFileNameAndLineNum,
                    givenWithClassName,
                    givenWithMethodName)
        }
    }

    @Test
    fun `w(String) called w(String) on mockUltimateLogger callCount times`() {
        loggingIfIsOnMultiPriorityLogger.w(
                givenMsg,
                givenWithFileNameAndLineNum,
                givenWithClassName,
                givenWithMethodName
        )

        verifyCalledOnMockUltimateLogger {
            w(givenMsg,
                    givenWithFileNameAndLineNum,
                    givenWithClassName,
                    givenWithMethodName)
        }
    }

    @Test
    fun `w(Throwable) called w(Throwable) on mockUltimateLogger callCount times`() {
        loggingIfIsOnMultiPriorityLogger.w(givenThrowable, givenMsg)

        verifyCalledOnMockUltimateLogger { w(givenThrowable, givenMsg) }
    }

    @Test
    fun `w(AnyT) called w(AnyT) on mockUltimateLogger callCount times`() {
        loggingIfIsOnMultiPriorityLogger.w(
                givenAny,
                givenWithFileNameAndLineNum,
                givenWithClassName,
                givenWithMethodName)

        verifyCalledOnMockUltimateLogger {
            w(givenAny,
                    givenWithFileNameAndLineNum,
                    givenWithClassName,
                    givenWithMethodName)
        }
    }

    @Test
    fun `e(String) called e(String) on mockUltimateLogger callCount times`() {
        loggingIfIsOnMultiPriorityLogger.e(
                givenMsg,
                givenWithFileNameAndLineNum,
                givenWithClassName,
                givenWithMethodName
        )

        verifyCalledOnMockUltimateLogger {
            e(givenMsg,
                    givenWithFileNameAndLineNum,
                    givenWithClassName,
                    givenWithMethodName)
        }
    }

    @Test
    fun `e(Throwable) called e(Throwable) on mockUltimateLogger callCount times`() {
        loggingIfIsOnMultiPriorityLogger.e(givenThrowable, givenMsg)

        verifyCalledOnMockUltimateLogger { e(givenThrowable, givenMsg) }
    }

    @Test
    fun `e(AnyT) called e(AnyT) on mockUltimateLogger callCount times`() {
        loggingIfIsOnMultiPriorityLogger.e(
                givenAny,
                givenWithFileNameAndLineNum,
                givenWithClassName,
                givenWithMethodName)

        verifyCalledOnMockUltimateLogger {
            e(givenAny,
                    givenWithFileNameAndLineNum,
                    givenWithClassName,
                    givenWithMethodName)
        }
    }

    @Test
    fun `wtf(String) called wtf(String) on mockUltimateLogger callCount times`() {
        loggingIfIsOnMultiPriorityLogger.wtf(
                givenMsg,
                givenWithFileNameAndLineNum,
                givenWithClassName,
                givenWithMethodName
        )

        verifyCalledOnMockUltimateLogger {
            wtf(givenMsg,
                    givenWithFileNameAndLineNum,
                    givenWithClassName,
                    givenWithMethodName)
        }
    }

    @Test
    fun `wtf(Throwable) called wtf(Throwable) on mockUltimateLogger callCount times`() {
        loggingIfIsOnMultiPriorityLogger.wtf(givenThrowable, givenMsg)

        verifyCalledOnMockUltimateLogger { wtf(givenThrowable, givenMsg) }
    }

    @Test
    fun `wtf(AnyT) called wtf(AnyT) on mockUltimateLogger callCount times`() {
        loggingIfIsOnMultiPriorityLogger.wtf(
                givenAny,
                givenWithFileNameAndLineNum,
                givenWithClassName,
                givenWithMethodName)

        verifyCalledOnMockUltimateLogger {
            wtf(givenAny,
                    givenWithFileNameAndLineNum,
                    givenWithClassName,
                    givenWithMethodName)
        }
    }

    private fun verifyCalledOnMockUltimateLogger(block: UltimateLogger.() -> Unit) =
            Mockito.verify(mockUltimateLogger, callCount).block()
}