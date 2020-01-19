package com.ultimatelogger.multiplatform

import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import org.junit.Assert
import org.junit.Test
import com.ultimatelogger.multiplatform.tag.dataprovider.TagData
import com.ultimatelogger.multiplatform.tag.dataprovider.TagDataConverter
import com.ultimatelogger.multiplatform.tag.dataprovider.stacktrace.StackTraceElementProvider
import com.ultimatelogger.multiplatform.tag.dataprovider.stacktrace.StackTraceTagDataProvider
import com.ultimatelogger.multiplatform.tag.dataprovider.stacktrace.ThreadNameProvider

internal class StackTraceTagDataProviderTest {

    private val givenClassName = "givenClassName"
    private val givenFileName = "givenFileName"
    private val givenMethodName = "givenMethodName"
    private val givenThreadName = "givenThreadName"
    private val givenLineNum = 12

    private val mockStackTraceElementProvider: StackTraceElementProvider = mock()
    private val mockTagDataConverter: TagDataConverter = mock()
    private val mockThreadNameProvider: ThreadNameProvider = mock()

    private val stackTraceTagDataProvider = StackTraceTagDataProvider(
            mockStackTraceElementProvider, mockTagDataConverter, mockThreadNameProvider)

    @Test
    fun `getTagData returns null if stackTraceElement from stackTraceElementProvider is null`() {
        given(mockStackTraceElementProvider.getStackTraceElement())
                .willReturn(null)

        Assert.assertEquals(null, stackTraceTagDataProvider.getTagData())
    }

    @Test
    fun `getTagData returns tagData converted from stackTraceElement`() {
        val givenStackTraceElement = StackTraceElement(givenClassName, givenMethodName,
                givenFileName, givenLineNum)

        given(mockStackTraceElementProvider.getStackTraceElement())
                .willReturn(givenStackTraceElement)

        val expectedTagData: TagData = mock()

        given(mockThreadNameProvider.threadName).willReturn(givenThreadName)

        given(mockTagDataConverter.fromStackTraceElement(givenStackTraceElement, givenThreadName))
                .willReturn(expectedTagData)

        Assert.assertEquals(expectedTagData, stackTraceTagDataProvider.getTagData())
    }
}