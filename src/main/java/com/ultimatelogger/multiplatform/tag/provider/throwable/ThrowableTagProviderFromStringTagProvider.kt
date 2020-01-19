package com.ultimatelogger.multiplatform.tag.provider.throwable

import com.ultimatelogger.multiplatform.tag.provider.string.StringTagProvider

internal class ThrowableTagProviderFromStringTagProvider(
        private val stringTagProvider: StringTagProvider) :
        ThrowableTagProvider {

    override fun provide(withThreadName: Boolean?) =
            stringTagProvider.provide(withThreadName = withThreadName,
                    withFileNameAndLineNum = true,
                    withClassName = false,
                    withMethodName = false)
}