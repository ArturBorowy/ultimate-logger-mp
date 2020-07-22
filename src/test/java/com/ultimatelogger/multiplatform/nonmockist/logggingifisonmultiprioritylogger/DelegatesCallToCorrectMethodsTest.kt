package com.ultimatelogger.multiplatform.nonmockist.logggingifisonmultiprioritylogger

import com.nhaarman.mockitokotlin2.times
import com.ultimatelogger.multiplatform.nonmockist.logggingifisonmultiprioritylogger.StubTagData.givenClassName
import com.ultimatelogger.multiplatform.nonmockist.logggingifisonmultiprioritylogger.StubTagData.givenFileName
import com.ultimatelogger.multiplatform.nonmockist.logggingifisonmultiprioritylogger.StubTagData.givenLineNumber
import com.ultimatelogger.multiplatform.nonmockist.logggingifisonmultiprioritylogger.StubTagData.givenMethodName
import com.ultimatelogger.multiplatform.nonmockist.logggingifisonmultiprioritylogger.StubTagData.givenThreadName
import org.junit.Test
import org.mockito.Mockito

internal class DelegatesCallToCorrectMethodsTest : LoggingIfIsOnMultiPriorityLoggerTest() {

    companion object {
        private const val expectedMsgAndAnyLogTag =
            "[$givenThreadName] ($givenFileName:$givenLineNumber) $givenClassName.$givenMethodName()"
        private const val expectedThrowableLogTag =
            "[$givenThreadName] ($givenFileName:$givenLineNumber)"
    }

    @Test
    fun `v(msg) calls v(properTag, msg) on provided MultiPriorityLogger`() {
        loggingIfIsOnMultiPriorityLogger.v(StubTagData.givenMsg)

        Mockito.verify(mockMultiPriorityLogger, times(1))
            .v(expectedMsgAndAnyLogTag, StubTagData.givenMsg)
    }

    @Test
    fun `v(throwable) calls v(properTag, properMsg, throwable) on provided MultiPriorityLogger`() {
        loggingIfIsOnMultiPriorityLogger.v(StubTagData.givenThrowable)

        Mockito.verify(mockMultiPriorityLogger, times(1))
            .v(expectedThrowableLogTag, null, StubTagData.givenThrowable)
    }

    @Test
    fun `v(anything) calls v(properTag, anything toString()) on provided MultiPriorityLogger`() {
        loggingIfIsOnMultiPriorityLogger.v(StubTagData.givenAny)

        Mockito.verify(mockMultiPriorityLogger, times(1))
            .v(expectedMsgAndAnyLogTag, StubTagData.givenAny.toString())
    }

    @Test
    fun `e(msg) calls e(properTag, msg) on provided MultiPriorityLogger`() {
        loggingIfIsOnMultiPriorityLogger.e(StubTagData.givenMsg)

        Mockito.verify(mockMultiPriorityLogger, times(1))
            .e(expectedMsgAndAnyLogTag, StubTagData.givenMsg)
    }

    @Test
    fun `e(throwable) calls e(properTag, properMsg, throwable) on provided MultiPriorityLogger`() {
        loggingIfIsOnMultiPriorityLogger.e(StubTagData.givenThrowable)

        Mockito.verify(mockMultiPriorityLogger, times(1))
            .e(expectedThrowableLogTag, null, StubTagData.givenThrowable)
    }

    @Test
    fun `e(anything) calls e(properTag, anything toString()) on provided MultiPriorityLogger`() {
        loggingIfIsOnMultiPriorityLogger.e(StubTagData.givenAny)

        Mockito.verify(mockMultiPriorityLogger, times(1))
            .e(expectedMsgAndAnyLogTag, StubTagData.givenAny.toString())
    }

    @Test
    fun `d(msg) calls d(properTag, msg) on provided MultiPriorityLogger`() {
        loggingIfIsOnMultiPriorityLogger.d(StubTagData.givenMsg)

        Mockito.verify(mockMultiPriorityLogger, times(1))
            .d(expectedMsgAndAnyLogTag, StubTagData.givenMsg)
    }

    @Test
    fun `d(throwable) calls d(properTag, properMsg, throwable) on provided MultiPriorityLogger`() {
        loggingIfIsOnMultiPriorityLogger.d(StubTagData.givenThrowable)

        Mockito.verify(mockMultiPriorityLogger, times(1))
            .d(expectedThrowableLogTag, null, StubTagData.givenThrowable)
    }

    @Test
    fun `d(anything) calls d(properTag, anything toString()) on provided MultiPriorityLogger`() {
        loggingIfIsOnMultiPriorityLogger.d(StubTagData.givenAny)

        Mockito.verify(mockMultiPriorityLogger, times(1))
            .d(expectedMsgAndAnyLogTag, StubTagData.givenAny.toString())
    }

    @Test
    fun `i(msg) calls i(properTag, msg) on provided MultiPriorityLogger`() {
        loggingIfIsOnMultiPriorityLogger.i(StubTagData.givenMsg)

        Mockito.verify(mockMultiPriorityLogger, times(1))
            .i(expectedMsgAndAnyLogTag, StubTagData.givenMsg)
    }

    @Test
    fun `i(throwable) calls i(properTag, properMsg, throwable) on provided MultiPriorityLogger`() {
        loggingIfIsOnMultiPriorityLogger.i(StubTagData.givenThrowable)

        Mockito.verify(mockMultiPriorityLogger, times(1))
            .i(expectedThrowableLogTag, null, StubTagData.givenThrowable)
    }

    @Test
    fun `i(anything) calls i(properTag, anything toString()) on provided MultiPriorityLogger`() {
        loggingIfIsOnMultiPriorityLogger.i(StubTagData.givenAny)

        Mockito.verify(mockMultiPriorityLogger, times(1))
            .i(expectedMsgAndAnyLogTag, StubTagData.givenAny.toString())
    }

    @Test
    fun `w(msg) calls w(properTag, msg) on provided MultiPriorityLogger`() {
        loggingIfIsOnMultiPriorityLogger.w(StubTagData.givenMsg)

        Mockito.verify(mockMultiPriorityLogger, times(1))
            .w(expectedMsgAndAnyLogTag, StubTagData.givenMsg)
    }

    @Test
    fun `w(throwable) calls w(properTag, properMsg, throwable) on provided MultiPriorityLogger`() {
        loggingIfIsOnMultiPriorityLogger.w(StubTagData.givenThrowable)

        Mockito.verify(mockMultiPriorityLogger, times(1))
            .w(expectedThrowableLogTag, null, StubTagData.givenThrowable)
    }

    @Test
    fun `w(anything) calls w(properTag, anything toString()) on provided MultiPriorityLogger`() {
        loggingIfIsOnMultiPriorityLogger.w(StubTagData.givenAny)

        Mockito.verify(mockMultiPriorityLogger, times(1))
            .w(expectedMsgAndAnyLogTag, StubTagData.givenAny.toString())
    }

    @Test
    fun `wtf(msg) calls wtf(properTag, msg) on provided MultiPriorityLogger`() {
        loggingIfIsOnMultiPriorityLogger.wtf(StubTagData.givenMsg)

        Mockito.verify(mockMultiPriorityLogger, times(1))
            .wtf(expectedMsgAndAnyLogTag, StubTagData.givenMsg)
    }

    @Test
    fun `wtf(throwable) calls wtf(properTag, properMsg, throwable) on provided MultiPriorityLogger`() {
        loggingIfIsOnMultiPriorityLogger.wtf(StubTagData.givenThrowable)

        Mockito.verify(mockMultiPriorityLogger, times(1))
            .wtf(expectedThrowableLogTag, null, StubTagData.givenThrowable)
    }

    @Test
    fun `wtf(anything) calls wtf(properTag, anything toString()) on provided MultiPriorityLogger`() {
        loggingIfIsOnMultiPriorityLogger.wtf(StubTagData.givenAny)

        Mockito.verify(mockMultiPriorityLogger, times(1))
            .wtf(expectedMsgAndAnyLogTag, StubTagData.givenAny.toString())
    }

    @Test
    fun `todo(anything) calls w(properTag, anything toString()) on provided MultiPriorityLogger`() {
        loggingIfIsOnMultiPriorityLogger.todo(StubTagData.givenAny)

        Mockito.verify(mockMultiPriorityLogger, times(1))
            .w(expectedMsgAndAnyLogTag, StubTagData.givenAny.toString())
    }
}