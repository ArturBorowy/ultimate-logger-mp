package com.ultimatelogger.multiplatform.tag

import kotlin.reflect.KClass

data class TagSettings(
    val shouldLogFileNameAndLineNum: Boolean,
    val shouldLogClassName: Boolean,
    val shouldLogMethodName: Boolean,
    val shouldLogThreadName: Boolean,
    val classesToIgnore: MutableList<KClass<*>> = mutableListOf(),
    val todoMethod: ((String) -> Unit)? = null
)