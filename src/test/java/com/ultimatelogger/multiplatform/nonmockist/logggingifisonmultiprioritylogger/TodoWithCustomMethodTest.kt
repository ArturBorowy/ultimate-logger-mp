package com.ultimatelogger.multiplatform.nonmockist.logggingifisonmultiprioritylogger

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.ultimatelogger.multiplatform.tag.TagSettings
import org.junit.Test
import org.mockito.Mockito
import java.util.function.Function

internal class TodoWithCustomMethodTest : LoggingIfIsOnMultiPriorityLoggerTest() {

    private val defaultTodoMethod = mock<((String) -> Unit)>()

    override fun setUp() {
        initLogger(
            true,
            TagSettings(
                shouldLogFileNameAndLineNum = true,
                shouldLogClassName = true,
                shouldLogMethodName = true,
                shouldLogThreadName = true,
                todoMethod = defaultTodoMethod
            )
        )
        stubStackTraceProvider()
        stubThreadNameProvider()
    }

    @Test
    fun `todo(anything) calls custom method provided in default TagSettings`() {
        loggingIfIsOnMultiPriorityLogger.todo(StubTagData.givenAny)

        Mockito.verify(defaultTodoMethod, times(1)).invoke(StubTagData.givenAny.toString())
    }
}