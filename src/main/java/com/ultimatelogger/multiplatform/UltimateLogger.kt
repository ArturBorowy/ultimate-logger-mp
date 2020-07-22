package com.ultimatelogger.multiplatform

interface UltimateLogger {

    companion object {
        private const val DEFAULT_LOG_MESSAGE = "Empty log"
    }

    fun v(msg: String? = DEFAULT_LOG_MESSAGE,
          withThreadName: Boolean? = null,
          withFileNameAndLineNum: Boolean? = null,
          withClassName: Boolean? = null,
          withMethodName: Boolean? = null)

    fun v(throwable: Throwable?, extraMessage: String? = null, withThreadName: Boolean? = null)

    fun <AnyT> v(anything: AnyT?,
                 withThreadName: Boolean? = null,
                 withFileNameAndLineNum: Boolean? = null,
                 withClassName: Boolean? = null,
                 withMethodName: Boolean? = null)

    fun d(msg: String? = DEFAULT_LOG_MESSAGE,
          withThreadName: Boolean? = null,
          withFileNameAndLineNum: Boolean? = null,
          withClassName: Boolean? = null,
          withMethodName: Boolean? = null)

    fun d(throwable: Throwable?, extraMessage: String? = null, withThreadName: Boolean? = null)

    fun <AnyT> d(anything: AnyT?,
                 withThreadName: Boolean? = null,
                 withFileNameAndLineNum: Boolean? = null,
                 withClassName: Boolean? = null,
                 withMethodName: Boolean? = null)

    fun i(msg: String? = DEFAULT_LOG_MESSAGE,
          withThreadName: Boolean? = null,
          withFileNameAndLineNum: Boolean? = null,
          withClassName: Boolean? = null,
          withMethodName: Boolean? = null)

    fun i(throwable: Throwable?, extraMessage: String? = null, withThreadName: Boolean? = null)

    fun <AnyT> i(anything: AnyT?,
                 withThreadName: Boolean? = null,
                 withFileNameAndLineNum: Boolean? = null,
                 withClassName: Boolean? = null,
                 withMethodName: Boolean? = null)

    fun w(msg: String? = DEFAULT_LOG_MESSAGE,
          withThreadName: Boolean? = null,
          withFileNameAndLineNum: Boolean? = null,
          withClassName: Boolean? = null,
          withMethodName: Boolean? = null)

    fun w(throwable: Throwable?, extraMessage: String? = null, withThreadName: Boolean? = null)

    fun <AnyT> w(anything: AnyT?,
                 withThreadName: Boolean? = null,
                 withFileNameAndLineNum: Boolean? = null,
                 withClassName: Boolean? = null,
                 withMethodName: Boolean? = null)

    fun e(msg: String? = DEFAULT_LOG_MESSAGE,
          withThreadName: Boolean? = null,
          withFileNameAndLineNum: Boolean? = null,
          withClassName: Boolean? = null,
          withMethodName: Boolean? = null)

    fun e(throwable: Throwable?, extraMessage: String? = null, withThreadName: Boolean? = null)

    fun <AnyT> e(anything: AnyT?,
                 withThreadName: Boolean? = null,
                 withFileNameAndLineNum: Boolean? = null,
                 withClassName: Boolean? = null,
                 withMethodName: Boolean? = null)

    fun wtf(msg: String? = DEFAULT_LOG_MESSAGE,
            withThreadName: Boolean? = null,
            withFileNameAndLineNum: Boolean? = null,
            withClassName: Boolean? = null,
            withMethodName: Boolean? = null)

    fun wtf(throwable: Throwable?, extraMessage: String? = null, withThreadName: Boolean? = null)

    fun <AnyT> wtf(anything: AnyT?,
                   withThreadName: Boolean? = null,
                   withFileNameAndLineNum: Boolean? = null,
                   withClassName: Boolean? = null,
                   withMethodName: Boolean? = null)

    fun <AnyT> todo(
        anything: AnyT?,
        withThreadName: Boolean? = null,
        withFileNameAndLineNum: Boolean? = null,
        withClassName: Boolean? = null,
        withMethodName: Boolean? = null
    )
}