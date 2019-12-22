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
    fun `v(String) doesn't call v(String) on mockUltimateLogger`() {
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
    fun `v(Throwable) doesn't call v(Throwable) on mockUltimateLogger`() {
        loggingIfIsOnMultiPriorityLogger.v(givenThrowable, givenMsg)

        verifyCalledOnMockUltimateLogger { v(givenThrowable, givenMsg) }
    }

    @Test
    fun `v(AnyT) doesn't call v(AnyT) on mockUltimateLogger`() {
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
    fun `d(String) doesn't call d(String) on mockUltimateLogger`() {
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
    fun `d(Throwable) doesn't call d(Throwable) on mockUltimateLogger`() {
        loggingIfIsOnMultiPriorityLogger.d(givenThrowable, givenMsg)

        verifyCalledOnMockUltimateLogger { d(givenThrowable, givenMsg) }
    }

    @Test
    fun `d(AnyT) doesn't call d(AnyT) on mockUltimateLogger`() {
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
    fun `i(String) doesn't call i(String) on mockUltimateLogger`() {
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
    fun `i(Throwable) doesn't call i(Throwable) on mockUltimateLogger`() {
        loggingIfIsOnMultiPriorityLogger.i(givenThrowable, givenMsg)

        verifyCalledOnMockUltimateLogger { i(givenThrowable, givenMsg) }
    }

    @Test
    fun `i(AnyT) doesn't call i(AnyT) on mockUltimateLogger`() {
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
    fun `w(String) doesn't call w(String) on mockUltimateLogger`() {
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
    fun `w(Throwable) doesn't call w(Throwable) on mockUltimateLogger`() {
        loggingIfIsOnMultiPriorityLogger.w(givenThrowable, givenMsg)

        verifyCalledOnMockUltimateLogger { w(givenThrowable, givenMsg) }
    }

    @Test
    fun `w(AnyT) doesn't call w(AnyT) on mockUltimateLogger`() {
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
    fun `e(String) doesn't call e(String) on mockUltimateLogger`() {
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
    fun `e(Throwable) doesn't call e(Throwable) on mockUltimateLogger`() {
        loggingIfIsOnMultiPriorityLogger.e(givenThrowable, givenMsg)

        verifyCalledOnMockUltimateLogger { e(givenThrowable, givenMsg) }
    }

    @Test
    fun `e(AnyT) doesn't call e(AnyT) on mockUltimateLogger`() {
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
    fun `wtf(String) doesn't call wtf(String) on mockUltimateLogger`() {
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
    fun `wtf(Throwable) doesn't call wtf(Throwable) on mockUltimateLogger`() {
        loggingIfIsOnMultiPriorityLogger.wtf(givenThrowable, givenMsg)

        verifyCalledOnMockUltimateLogger { wtf(givenThrowable, givenMsg) }
    }

    @Test
    fun `wtf(AnyT) doesn't call wtf(AnyT) on mockUltimateLogger`() {
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