package com.ultimatelogger.multiplatform

import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import com.ultimatelogger.multiplatform.tag.dataprovider.TagDataConverter
import org.junit.Assert
import org.junit.Test

internal class TagDataConverterTest {

    private val givenClassName = "givenClassName"
    private val givenFileName = "givenFileName"
    private val givenMethodName = "givenMethodName"
    private val givenThreadName = "givenThreadName"
    private val givenLineNum = 12

    private val tagDataConverter = TagDataConverter()

    @Test
    fun `fromStackTraceElement returns TagData with data from given stackTraceElement`() {
        val givenStackTraceElement = StackTraceElement(givenClassName,
                givenMethodName, givenFileName, givenLineNum)

        val actualTagData =
                tagDataConverter.fromStackTraceElement(givenStackTraceElement, givenThreadName)

        Assert.assertEquals(givenClassName, actualTagData.className)
        Assert.assertEquals(givenFileName, actualTagData.fileName)
        Assert.assertEquals(givenMethodName, actualTagData.methodName)
        Assert.assertEquals(givenThreadName, actualTagData.threadName)
        Assert.assertEquals(givenLineNum, actualTagData.lineNumber.toInt())
    }

    @Test
    fun `fromStackTraceElement null`() {
        val givenStackTraceElement : StackTraceElement = mock()

        given(givenStackTraceElement.fileName).willReturn(null)
        given(givenStackTraceElement.className).willReturn(givenClassName)
        given(givenStackTraceElement.methodName).willReturn(givenMethodName)
        given(givenStackTraceElement.lineNumber).willReturn(givenLineNum)

        val actualTagData =
                tagDataConverter.fromStackTraceElement(givenStackTraceElement, givenThreadName)

        Assert.assertEquals(givenClassName, actualTagData.className)
        Assert.assertEquals("UnknownFile", actualTagData.fileName)
        Assert.assertEquals(givenMethodName, actualTagData.methodName)
        Assert.assertEquals(givenThreadName, actualTagData.threadName)
        Assert.assertEquals(givenLineNum, actualTagData.lineNumber.toInt())
    }
}