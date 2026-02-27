package com.ultimatelogger.multiplatform.tag

import org.mockito.kotlin.given
import org.mockito.kotlin.mock
import org.junit.Assert
import org.junit.Test
import com.ultimatelogger.multiplatform.tag.provider.string.StringTagProvider
import com.ultimatelogger.multiplatform.tag.provider.throwable.ThrowableTagProviderFromStringTagProvider

internal class ThrowableTagProviderFromStringTagProviderTest {

    private val mockStringTagProvider: StringTagProvider = mock()

    private val throwableTagProviderFromStringTagProvider =
            ThrowableTagProviderFromStringTagProvider(mockStringTagProvider)

    @Test
    fun `provide() returns tag from stringTagProvider provide(true, false, false)`() {
        val givenTag = "okpwro23[ik[2"

        val givenWithThreadName = true

        given(mockStringTagProvider
                .provide(withThreadName = givenWithThreadName,
                        withFileNameAndLineNum = true,
                        withClassName = false,
                        withMethodName = false))
                .willReturn(givenTag)

        Assert.assertEquals(givenTag,
                throwableTagProviderFromStringTagProvider.provide(givenWithThreadName))
    }
}