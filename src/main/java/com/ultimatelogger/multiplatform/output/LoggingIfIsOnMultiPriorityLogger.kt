package com.ultimatelogger.multiplatform.output

import com.ultimatelogger.multiplatform.UltimateLogger
import com.ultimatelogger.multiplatform.di.LazyServiceLocator
import com.ultimatelogger.multiplatform.util.runIf

open class LoggingIfIsOnMultiPriorityLogger : UltimateLogger {

    internal var shouldLog = false

    private val logger: UltimateLogger by LazyServiceLocator.getDependency()

    override fun v(msg: String?,
                   withFileNameAndLineNum: Boolean?,
                   withClassName: Boolean?,
                   withMethodName: Boolean?) {
        runIfIsLoggingOn { logger.v(msg, withFileNameAndLineNum, withClassName, withMethodName) }
    }

    override fun v(throwable: Throwable?,
                   extraMessage: String?) {
        runIfIsLoggingOn { logger.v(throwable, extraMessage) }
    }

    override fun <AnyT> v(anything: AnyT?,
                          withFileNameAndLineNum: Boolean?,
                          withClassName: Boolean?,
                          withMethodName: Boolean?) {
        runIfIsLoggingOn { logger.v(anything, withFileNameAndLineNum, withClassName, withMethodName) }
    }

    override fun d(msg: String?,
                   withFileNameAndLineNum: Boolean?,
                   withClassName: Boolean?,
                   withMethodName: Boolean?) {
        runIfIsLoggingOn { logger.d(msg, withFileNameAndLineNum, withClassName, withMethodName) }
    }

    override fun d(throwable: Throwable?,
                   extraMessage: String?) {
        runIfIsLoggingOn { logger.d(throwable, extraMessage) }
    }

    override fun <AnyT> d(anything: AnyT?,
                          withFileNameAndLineNum: Boolean?,
                          withClassName: Boolean?,
                          withMethodName: Boolean?) {
        runIfIsLoggingOn { logger.d(anything, withFileNameAndLineNum, withClassName, withMethodName) }
    }

    override fun i(msg: String?,
                   withFileNameAndLineNum: Boolean?,
                   withClassName: Boolean?,
                   withMethodName: Boolean?) {
        runIfIsLoggingOn { logger.i(msg, withFileNameAndLineNum, withClassName, withMethodName) }
    }

    override fun i(throwable: Throwable?,
                   extraMessage: String?) {
        runIfIsLoggingOn { logger.i(throwable, extraMessage) }
    }

    override fun <AnyT> i(anything: AnyT?,
                          withFileNameAndLineNum: Boolean?,
                          withClassName: Boolean?,
                          withMethodName: Boolean?) {
        runIfIsLoggingOn { logger.i(anything, withFileNameAndLineNum, withClassName, withMethodName) }
    }

    override fun w(msg: String?,
                   withFileNameAndLineNum: Boolean?,
                   withClassName: Boolean?,
                   withMethodName: Boolean?) {
        runIfIsLoggingOn { logger.w(msg, withFileNameAndLineNum, withClassName, withMethodName) }
    }

    override fun w(throwable: Throwable?,
                   extraMessage: String?) {
        runIfIsLoggingOn { logger.w(throwable, extraMessage) }
    }

    override fun <AnyT> w(anything: AnyT?,
                          withFileNameAndLineNum: Boolean?,
                          withClassName: Boolean?,
                          withMethodName: Boolean?) {
        runIfIsLoggingOn { logger.w(anything, withFileNameAndLineNum, withClassName, withMethodName) }
    }

    override fun e(msg: String?,
                   withFileNameAndLineNum: Boolean?,
                   withClassName: Boolean?,
                   withMethodName: Boolean?) {
        runIfIsLoggingOn { logger.e(msg, withFileNameAndLineNum, withClassName, withMethodName) }
    }

    override fun e(throwable: Throwable?,
                   extraMessage: String?) {
        runIfIsLoggingOn { logger.e(throwable, extraMessage) }
    }

    override fun <AnyT> e(anything: AnyT?,
                          withFileNameAndLineNum: Boolean?,
                          withClassName: Boolean?,
                          withMethodName: Boolean?) {
        runIfIsLoggingOn { logger.e(anything, withFileNameAndLineNum, withClassName, withMethodName) }
    }

    override fun wtf(msg: String?,
                     withFileNameAndLineNum: Boolean?,
                     withClassName: Boolean?,
                     withMethodName: Boolean?) {
        runIfIsLoggingOn { logger.wtf(msg, withFileNameAndLineNum, withClassName, withMethodName) }
    }

    override fun wtf(throwable: Throwable?,
                     extraMessage: String?) {
        runIfIsLoggingOn { logger.wtf(throwable, extraMessage) }
    }

    override fun <AnyT> wtf(anything: AnyT?,
                            withFileNameAndLineNum: Boolean?,
                            withClassName: Boolean?,
                            withMethodName: Boolean?) {
        runIfIsLoggingOn { logger.wtf(anything, withFileNameAndLineNum, withClassName, withMethodName) }
    }

    private fun runIfIsLoggingOn(block: () -> Unit) = runIf(shouldLog) { block() }
}