package com.ultimatelogger.multiplatform.tag.provider.string

internal interface StringTagProvider {

    fun provide(withThreadName: Boolean?,
                withFileNameAndLineNum: Boolean?,
                withClassName: Boolean?,
                withMethodName: Boolean?): String
}