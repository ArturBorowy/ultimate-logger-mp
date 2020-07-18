package com.ultimatelogger.multiplatform.nonmockist.logggingifisonmultiprioritylogger

import com.nhaarman.mockitokotlin2.times
import com.ultimatelogger.multiplatform.nonmockist.logggingifisonmultiprioritylogger.StubTagData.givenClassName
import com.ultimatelogger.multiplatform.nonmockist.logggingifisonmultiprioritylogger.StubTagData.givenFileName
import com.ultimatelogger.multiplatform.nonmockist.logggingifisonmultiprioritylogger.StubTagData.givenLineNumber
import com.ultimatelogger.multiplatform.nonmockist.logggingifisonmultiprioritylogger.StubTagData.givenMethodName
import com.ultimatelogger.multiplatform.nonmockist.logggingifisonmultiprioritylogger.StubTagData.givenMsg
import com.ultimatelogger.multiplatform.nonmockist.logggingifisonmultiprioritylogger.StubTagData.givenThreadName
import com.ultimatelogger.multiplatform.tag.TagSettings
import org.junit.Test
import org.mockito.Mockito

internal class TagBuildingTest : LoggingIfIsOnMultiPriorityLoggerTest() {

    override fun setUp() {
        stubStackTraceProvider()
        stubThreadNameProvider()
    }

    @Test
    fun `shouldLogFileNameAndLineNum = true | shouldLogClassName = true | shouldLogMethodName = true | shouldLogThreadName = true`() {
        initLogger(
            true,
            TagSettings(
                shouldLogFileNameAndLineNum = true,
                shouldLogClassName = true,
                shouldLogMethodName = true,
                shouldLogThreadName = true
            )
        )

        testVMethodCalled(
            "[$givenThreadName] ($givenFileName:$givenLineNumber) $givenClassName.$givenMethodName()"
        )
    }

    private fun testVMethodCalled(expectedTag: String) {
        loggingIfIsOnMultiPriorityLogger.v(givenMsg)

        Mockito.verify(mockMultiPriorityLogger, times(1)).v(expectedTag, givenMsg)
    }

    @Test
    fun `shouldLogFileNameAndLineNum = false | shouldLogClassName = true | shouldLogMethodName = true | shouldLogThreadName = true`() {
        initLogger(
            true,
            TagSettings(
                shouldLogFileNameAndLineNum = false,
                shouldLogClassName = true,
                shouldLogMethodName = true,
                shouldLogThreadName = true
            )
        )

        testVMethodCalled("[$givenThreadName]  $givenClassName.$givenMethodName()")
    }

    @Test
    fun `shouldLogFileNameAndLineNum = true | shouldLogClassName = false | shouldLogMethodName = true | shouldLogThreadName = true`() {
        initLogger(
            true,
            TagSettings(
                shouldLogFileNameAndLineNum = true,
                shouldLogClassName = false,
                shouldLogMethodName = true,
                shouldLogThreadName = true
            )
        )

        testVMethodCalled("[$givenThreadName] ($givenFileName:$givenLineNumber) .$givenMethodName()")
    }

    @Test
    fun `shouldLogFileNameAndLineNum = true | shouldLogClassName = true | shouldLogMethodName = false | shouldLogThreadName = true`() {
        initLogger(
            true,
            TagSettings(
                shouldLogFileNameAndLineNum = true,
                shouldLogClassName = true,
                shouldLogMethodName = false,
                shouldLogThreadName = true
            )
        )

        testVMethodCalled("[$givenThreadName] ($givenFileName:$givenLineNumber) $givenClassName")
    }

    @Test
    fun `shouldLogFileNameAndLineNum = true | shouldLogClassName = true | shouldLogMethodName = true | shouldLogThreadName = false`() {
        initLogger(
            true,
            TagSettings(
                shouldLogFileNameAndLineNum = true,
                shouldLogClassName = true,
                shouldLogMethodName = true,
                shouldLogThreadName = false
            )
        )

        testVMethodCalled("($givenFileName:$givenLineNumber) $givenClassName.$givenMethodName()")
    }

    @Test
    fun `shouldLogFileNameAndLineNum = false | shouldLogClassName = false | shouldLogMethodName = true | shouldLogThreadName = true`() {
        initLogger(
            true,
            TagSettings(
                shouldLogFileNameAndLineNum = false,
                shouldLogClassName = false,
                shouldLogMethodName = true,
                shouldLogThreadName = true
            )
        )

        testVMethodCalled("[$givenThreadName]  .$givenMethodName()")
    }

    @Test
    fun `shouldLogFileNameAndLineNum = true | shouldLogClassName = true | shouldLogMethodName = false | shouldLogThreadName = false`() {
        initLogger(
            true,
            TagSettings(
                shouldLogFileNameAndLineNum = true,
                shouldLogClassName = true,
                shouldLogMethodName = false,
                shouldLogThreadName = false
            )
        )

        testVMethodCalled("($givenFileName:$givenLineNumber) $givenClassName")
    }

    @Test
    fun `shouldLogFileNameAndLineNum = false | shouldLogClassName = true | shouldLogMethodName = true | shouldLogThreadName = false`() {
        initLogger(
            true,
            TagSettings(
                shouldLogFileNameAndLineNum = false,
                shouldLogClassName = true,
                shouldLogMethodName = true,
                shouldLogThreadName = false
            )
        )

        testVMethodCalled("$givenClassName.$givenMethodName()")
    }

    @Test
    fun `shouldLogFileNameAndLineNum = true | shouldLogClassName = false | shouldLogMethodName = false | shouldLogThreadName = true`() {
        initLogger(
            true,
            TagSettings(
                shouldLogFileNameAndLineNum = true,
                shouldLogClassName = false,
                shouldLogMethodName = false,
                shouldLogThreadName = true
            )
        )

        testVMethodCalled("[$givenThreadName] ($givenFileName:$givenLineNumber)")
    }

    @Test
    fun `shouldLogFileNameAndLineNum = true | shouldLogClassName = false | shouldLogMethodName = true | shouldLogThreadName = false`() {
        initLogger(
            true,
            TagSettings(
                shouldLogFileNameAndLineNum = true,
                shouldLogClassName = false,
                shouldLogMethodName = true,
                shouldLogThreadName = false
            )
        )

        testVMethodCalled("($givenFileName:$givenLineNumber) .$givenMethodName()")
    }

    @Test
    fun `shouldLogFileNameAndLineNum = false | shouldLogClassName = true | shouldLogMethodName = false | shouldLogThreadName = true`() {
        initLogger(
            true,
            TagSettings(
                shouldLogFileNameAndLineNum = false,
                shouldLogClassName = true,
                shouldLogMethodName = false,
                shouldLogThreadName = true
            )
        )

        testVMethodCalled("[$givenThreadName]  $givenClassName")
    }

    @Test
    fun `shouldLogFileNameAndLineNum = false | shouldLogClassName = false | shouldLogMethodName = false | shouldLogThreadName = false`() {
        initLogger(
            true,
            TagSettings(
                shouldLogFileNameAndLineNum = false,
                shouldLogClassName = false,
                shouldLogMethodName = false,
                shouldLogThreadName = false
            )
        )

        testVMethodCalled("UltimateLogger")
    }

    @Test
    fun `shouldLogFileNameAndLineNum = true | shouldLogClassName = false | shouldLogMethodName = false | shouldLogThreadName = false`() {
        initLogger(
            true,
            TagSettings(
                shouldLogFileNameAndLineNum = true,
                shouldLogClassName = false,
                shouldLogMethodName = false,
                shouldLogThreadName = false
            )
        )

        testVMethodCalled("($givenFileName:$givenLineNumber)")
    }

    @Test
    fun `shouldLogFileNameAndLineNum = false | shouldLogClassName = true | shouldLogMethodName = false | shouldLogThreadName = false`() {
        initLogger(
            true,
            TagSettings(
                shouldLogFileNameAndLineNum = false,
                shouldLogClassName = true,
                shouldLogMethodName = false,
                shouldLogThreadName = false
            )
        )

        testVMethodCalled(givenClassName)
    }

    @Test
    fun `shouldLogFileNameAndLineNum = false | shouldLogClassName = false | shouldLogMethodName = true | shouldLogThreadName = false`() {
        initLogger(
            true,
            TagSettings(
                shouldLogFileNameAndLineNum = false,
                shouldLogClassName = false,
                shouldLogMethodName = true,
                shouldLogThreadName = false
            )
        )

        testVMethodCalled(".$givenMethodName()")
    }

    @Test
    fun `shouldLogFileNameAndLineNum = false | shouldLogClassName = false | shouldLogMethodName = false | shouldLogThreadName = true`() {
        initLogger(
            true,
            TagSettings(
                shouldLogFileNameAndLineNum = false,
                shouldLogClassName = false,
                shouldLogMethodName = false,
                shouldLogThreadName = true
            )
        )

        testVMethodCalled("[$givenThreadName]")
    }
}