package com.ultimatelogger.multiplatform.tag.dataprovider.stacktrace

class ThreadNameProvider {

    val threadName: String
        get() = Thread.currentThread().name ?: "UnknownThread"
}