package com.ultimatelogger.multiplatform.swichablemultipriorityultimatelogger

import com.nhaarman.mockitokotlin2.given
import com.ultimatelogger.multiplatform.SwitchableMultiPriorityUltimateLogger
import com.ultimatelogger.multiplatform.output.MultiPriorityLogger
import org.junit.Test
import org.mockito.Mockito

internal class SwitchableMultiPriorityUltimateLoggerThrowableTest :
        SwitchableMultiPriorityUltimateLoggerTest() {

    @Test
    fun `v(Throwable, ) calls logger v() with same throwable and tag from stringTagProvider`() {
        verifyFirstActionCallSecondActionWithSameThrowableAndTagFromThrowableTagProvider(
                { throwable, msg, withThreadName -> v(throwable, msg, withThreadName) },
                { tag, msg, throwable -> v(tag, msg, throwable) }
        )
    }

    private fun verifyFirstActionCallSecondActionWithSameThrowableAndTagFromThrowableTagProvider(
            switchableMultiPriorityUltimateLoggerAction:
            SwitchableMultiPriorityUltimateLogger.(Throwable, String, Boolean) -> Unit,
            multiPriorityLoggerAction: MultiPriorityLogger.(String, String, Throwable) -> Unit) {
        val givenWithTreadName = true
        val givenMsg = "tp[flw2g[pk4m["
        val givenThrowable = Exception()

        val givenTag = "]2[3l;]23;]"

        given(mockThrowableTagProvider.provide(givenWithTreadName)).willReturn(givenTag)

        switchableMultiPriorityUltimateLogger
                .switchableMultiPriorityUltimateLoggerAction(givenThrowable, givenMsg, givenWithTreadName)

        Mockito.verify(mockMultiPriorityLogger, Mockito.times(1))
                .multiPriorityLoggerAction(givenTag, givenMsg, givenThrowable)
    }

    @Test
    fun `d(Throwable, ) calls logger d() with same throwable and tag from stringTagProvider`() {
        verifyFirstActionCallSecondActionWithSameThrowableAndTagFromThrowableTagProvider(
                { throwable, msg, withThreadName -> d(throwable, msg, withThreadName) },
                { tag, msg, throwable -> d(tag, msg, throwable) }
        )
    }

    @Test
    fun `i(Throwable, ) calls logger i() with same throwable and tag from stringTagProvider`() {
        verifyFirstActionCallSecondActionWithSameThrowableAndTagFromThrowableTagProvider(
                { throwable, msg, withThreadName -> i(throwable, msg, withThreadName) },
                { tag, msg, throwable -> i(tag, msg, throwable) }
        )
    }

    @Test
    fun `w(Throwable, ) calls logger w() with same throwable and tag from stringTagProvider`() {
        verifyFirstActionCallSecondActionWithSameThrowableAndTagFromThrowableTagProvider(
                { throwable, msg, withThreadName -> w(throwable, msg, withThreadName) },
                { tag, msg, throwable -> w(tag, msg, throwable) }
        )
    }

    @Test
    fun `e(Throwable, ) calls logger e() with same throwable and tag from stringTagProvider`() {
        verifyFirstActionCallSecondActionWithSameThrowableAndTagFromThrowableTagProvider(
                { throwable, msg, withThreadName -> e(throwable, msg, withThreadName) },
                { tag, msg, throwable -> e(tag, msg, throwable) }
        )
    }

    @Test
    fun `wtf(Throwable, ) calls logger wtf() with same throwable and tag from stringTagProvider`() {
        verifyFirstActionCallSecondActionWithSameThrowableAndTagFromThrowableTagProvider(
                { throwable, msg, withThreadName -> wtf(throwable, msg, withThreadName) },
                { tag, msg, throwable -> wtf(tag, msg, throwable) }
        )
    }
}