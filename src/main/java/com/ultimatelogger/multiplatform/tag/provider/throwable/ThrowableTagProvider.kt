package com.ultimatelogger.multiplatform.tag.provider.throwable

internal interface ThrowableTagProvider {

    fun provide(withThreadName: Boolean?): String
}