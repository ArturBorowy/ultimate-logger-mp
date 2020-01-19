package com.ultimatelogger.multiplatform.swichablemultipriorityultimatelogger

import com.nhaarman.mockitokotlin2.given
import com.ultimatelogger.multiplatform.SwitchableMultiPriorityUltimateLogger
import com.ultimatelogger.multiplatform.output.MultiPriorityLogger
import org.junit.Test
import org.mockito.Mockito

internal class SwitchableMultiPriorityUltimateLoggerMsgTest :
        SwitchableMultiPriorityUltimateLoggerTest() {

    @Test
    fun `v(String, ) calls logger v() with same msg and tag from stringTagProvider`() {
        verifyFirstActionCallSecondActionWithSameMsgAndTagFromStringTagProvider(
                { msg,
                  withThreadName,
                  withFileNameAndLineNum,
                  withClassName,
                  withMethodName ->
                    v(msg, withThreadName, withFileNameAndLineNum, withClassName, withMethodName)
                },
                { tag,
                  msg ->
                    v(tag, msg)
                }
        )
    }

    private fun verifyFirstActionCallSecondActionWithSameMsgAndTagFromStringTagProvider(
            switchableMultiPriorityUltimateLoggerAction:
            SwitchableMultiPriorityUltimateLogger.(String, Boolean, Boolean, Boolean, Boolean) -> Unit,
            multiPriorityLoggerAction: MultiPriorityLogger.(String, String) -> Unit) {
        val givenMsg = "][qr;e[;]l]["

        val givenWithThreadName = true
        val givenWithFileNameAndLineNum = true
        val givenWithClassName = true
        val givenWithMethodName = true

        val givenTag = "]2[3l;]23;]"

        given(mockStringTagProvider.provide(givenWithThreadName,
                givenWithFileNameAndLineNum,
                givenWithClassName,
                givenWithMethodName))
                .willReturn(givenTag)

        switchableMultiPriorityUltimateLogger.switchableMultiPriorityUltimateLoggerAction(givenMsg,
                givenWithThreadName,
                givenWithFileNameAndLineNum,
                givenWithClassName,
                givenWithMethodName)

        Mockito.verify(mockMultiPriorityLogger, Mockito.times(1))
                .multiPriorityLoggerAction(givenTag, givenMsg)
    }

    @Test
    fun `d(String, ) calls logger d() with same msg and tag from stringTagProvider`() {
        verifyFirstActionCallSecondActionWithSameMsgAndTagFromStringTagProvider(
                { msg,
                  withThreadName,
                  withFileNameAndLineNum,
                  withClassName,
                  withMethodName ->
                    d(msg, withThreadName, withFileNameAndLineNum, withClassName, withMethodName)
                },
                { tag,
                  msg ->
                    d(tag, msg)
                }
        )
    }

    @Test
    fun `i(String, ) calls logger i() with same msg and tag from stringTagProvider`() {
        verifyFirstActionCallSecondActionWithSameMsgAndTagFromStringTagProvider(
                { msg,
                  withThreadName,
                  withFileNameAndLineNum,
                  withClassName,
                  withMethodName ->
                    i(msg, withThreadName, withFileNameAndLineNum, withClassName, withMethodName)
                },
                { tag,
                  msg ->
                    i(tag, msg)
                }
        )
    }

    @Test
    fun `w(String, ) calls logger w() with same msg and tag from stringTagProvider`() {
        verifyFirstActionCallSecondActionWithSameMsgAndTagFromStringTagProvider(
                { msg,
                  withThreadName,
                  withFileNameAndLineNum,
                  withClassName,
                  withMethodName ->
                    w(msg, withThreadName, withFileNameAndLineNum, withClassName, withMethodName)
                },
                { tag,
                  msg ->
                    w(tag, msg)
                }
        )
    }

    @Test
    fun `e(String, ) calls logger e() with same msg and tag from stringTagProvider`() {
        verifyFirstActionCallSecondActionWithSameMsgAndTagFromStringTagProvider(
                { msg,
                  withThreadName,
                  withFileNameAndLineNum,
                  withClassName,
                  withMethodName ->
                    e(msg, withThreadName, withFileNameAndLineNum, withClassName, withMethodName)
                },
                { tag,
                  msg ->
                    e(tag, msg)
                }
        )
    }

    @Test
    fun `wtf(String, ) calls logger wtf() with same msg and tag from stringTagProvider`() {
        verifyFirstActionCallSecondActionWithSameMsgAndTagFromStringTagProvider(
                { msg,
                  withThreadName,
                  withFileNameAndLineNum,
                  withClassName,
                  withMethodName ->
                    wtf(msg, withThreadName, withFileNameAndLineNum, withClassName, withMethodName)
                },
                { tag,
                  msg ->
                    wtf(tag, msg)
                }
        )
    }
}