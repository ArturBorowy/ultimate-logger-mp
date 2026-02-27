package com.ultimatelogger.multiplatform.nonmockist.logggingifisonmultiprioritylogger

import org.mockito.kotlin.anyOrNull
import org.mockito.kotlin.never
import com.ultimatelogger.multiplatform.tag.TagSettings
import org.junit.Test
import org.mockito.Mockito

internal class ShouldLogFalseSetTest : LoggingIfIsOnMultiPriorityLoggerTest() {

    override fun setUp() {
        initLogger(
            false,
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

    @Test
    fun `v(msg) doesn't call v(any, any) on provided MultiPriorityLogger`() {
        loggingIfIsOnMultiPriorityLogger.v(StubTagData.givenMsg)

        Mockito.verify(mockMultiPriorityLogger, never()).v(anyOrNull(), anyOrNull(), anyOrNull())
    }
}