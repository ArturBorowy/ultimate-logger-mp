package com.ultimatelogger.multiplatform.nonmockist.logggingifisonmultiprioritylogger

import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import com.ultimatelogger.multiplatform.MpUltimateLoggerInitializer
import com.ultimatelogger.multiplatform.nonmockist.logggingifisonmultiprioritylogger.StubTagData.givenThreadName
import com.ultimatelogger.multiplatform.output.LoggingIfIsOnMultiPriorityLogger
import com.ultimatelogger.multiplatform.output.MultiPriorityLogger
import com.ultimatelogger.multiplatform.tag.TagSettings
import com.ultimatelogger.multiplatform.tag.dataprovider.stacktrace.StackTraceProvider
import com.ultimatelogger.multiplatform.tag.dataprovider.stacktrace.ThreadNameProvider
import org.junit.After
import org.junit.Before
import org.koin.dsl.module

internal abstract class LoggingIfIsOnMultiPriorityLoggerTest {

    protected val mockThreadNameProvider: ThreadNameProvider = mock()
    protected val mockStackTraceProvider: StackTraceProvider = mock()
    protected val mockMultiPriorityLogger: MultiPriorityLogger = mock()

    protected val loggingIfIsOnMultiPriorityLogger
            by lazy { LoggingIfIsOnMultiPriorityLogger() }

    @Before
    open fun setUp() {
        initLogger(
            true,
            TagSettings(
                shouldLogFileNameAndLineNum = true,
                shouldLogClassName = true,
                shouldLogMethodName = true,
                shouldLogThreadName = true
            )
        )
        stubStackTraceProvider()
        stubThreadNameProvider()
    }

    protected fun initLogger(
        shouldLog: Boolean,
        tagSettings: TagSettings
    ) {
        MpUltimateLoggerInitializer.init(
            shouldLog,
            tagSettings,
            lazy { loggingIfIsOnMultiPriorityLogger },
            mockMultiPriorityLogger,
            module {
                single(override = true) { mockStackTraceProvider }
                single(override = true) { mockThreadNameProvider }
            }
        )
    }

    protected fun stubStackTraceProvider() {
        val givenStackTraceElement = StackTraceElement(
            StubTagData.givenClassName,
            StubTagData.givenMethodName,
            StubTagData.givenFileName,
            StubTagData.givenLineNumber
        )
        given(mockStackTraceProvider.provide()).willReturn(listOf(givenStackTraceElement))
    }

    protected fun stubThreadNameProvider() {
        given(mockThreadNameProvider.threadName).willReturn(givenThreadName)
    }

    @After
    fun tearDown() {
        MpUltimateLoggerInitializer.destroy()
    }
}