package com.ultimatelogger.multiplatform.output

import com.ultimatelogger.multiplatform.UltimateLogger
import com.ultimatelogger.multiplatform.di.LazyServiceLocator
import com.ultimatelogger.multiplatform.util.runIf

open class LoggingIfIsOnMultiPriorityLogger : UltimateLogger {

    internal var shouldLog = false

    private val logger: UltimateLogger by LazyServiceLocator.getDependency()

    override fun v(msg: String?,
                   withThreadName: Boolean?,
                   withFileNameAndLineNum: Boolean?,
                   withClassName: Boolean?,
                   withMethodName: Boolean?) {
        runIfIsLoggingOn {
            logger.v(msg, withThreadName, withFileNameAndLineNum, withClassName, withMethodName)
        }
    }

    override fun v(throwable: Throwable?,
                   extraMessage: String?,
                   withThreadName: Boolean?) {
        runIfIsLoggingOn { logger.v(throwable, extraMessage, withThreadName) }
    }

    override fun <AnyT> v(anything: AnyT?,
                          withThreadName: Boolean?,
                          withFileNameAndLineNum: Boolean?,
                          withClassName: Boolean?,
                          withMethodName: Boolean?) {
        runIfIsLoggingOn {
            logger.v(anything,
                    withThreadName,
                    withFileNameAndLineNum,
                    withClassName,
                    withMethodName)
        }
    }

    override fun d(msg: String?,
                   withThreadName: Boolean?,
                   withFileNameAndLineNum: Boolean?,
                   withClassName: Boolean?,
                   withMethodName: Boolean?) {
        runIfIsLoggingOn {
            logger.d(msg, withThreadName, withFileNameAndLineNum, withClassName, withMethodName)
        }
    }

    override fun d(throwable: Throwable?,
                   extraMessage: String?,
                   withThreadName: Boolean?) {
        runIfIsLoggingOn { logger.d(throwable, extraMessage, withThreadName) }
    }

    override fun <AnyT> d(anything: AnyT?,
                          withThreadName: Boolean?,
                          withFileNameAndLineNum: Boolean?,
                          withClassName: Boolean?,
                          withMethodName: Boolean?) {
        runIfIsLoggingOn {
            logger.d(anything,
                    withThreadName,
                    withFileNameAndLineNum,
                    withClassName,
                    withMethodName)
        }
    }

    override fun i(msg: String?,
                   withThreadName: Boolean?,
                   withFileNameAndLineNum: Boolean?,
                   withClassName: Boolean?,
                   withMethodName: Boolean?) {
        runIfIsLoggingOn {
            logger.i(msg, withThreadName, withFileNameAndLineNum, withClassName, withMethodName)
        }
    }

    override fun i(throwable: Throwable?,
                   extraMessage: String?,
                   withThreadName: Boolean?) {
        runIfIsLoggingOn { logger.i(throwable, extraMessage, withThreadName) }
    }

    override fun <AnyT> i(anything: AnyT?,
                          withThreadName: Boolean?,
                          withFileNameAndLineNum: Boolean?,
                          withClassName: Boolean?,
                          withMethodName: Boolean?) {
        runIfIsLoggingOn {
            logger.i(anything,
                    withThreadName,
                    withFileNameAndLineNum,
                    withClassName,
                    withMethodName)
        }
    }

    override fun w(msg: String?,
                   withThreadName: Boolean?,
                   withFileNameAndLineNum: Boolean?,
                   withClassName: Boolean?,
                   withMethodName: Boolean?) {
        runIfIsLoggingOn {
            logger.w(msg, withThreadName, withFileNameAndLineNum, withClassName, withMethodName)
        }
    }

    override fun w(throwable: Throwable?,
                   extraMessage: String?,
                   withThreadName: Boolean?) {
        runIfIsLoggingOn { logger.w(throwable, extraMessage, withThreadName) }
    }

    override fun <AnyT> w(anything: AnyT?,
                          withThreadName: Boolean?,
                          withFileNameAndLineNum: Boolean?,
                          withClassName: Boolean?,
                          withMethodName: Boolean?) {
        runIfIsLoggingOn {
            logger.w(anything,
                    withThreadName,
                    withFileNameAndLineNum,
                    withClassName,
                    withMethodName)
        }
    }

    override fun e(msg: String?,
                   withThreadName: Boolean?,
                   withFileNameAndLineNum: Boolean?,
                   withClassName: Boolean?,
                   withMethodName: Boolean?) {
        runIfIsLoggingOn {
            logger.e(msg, withThreadName, withFileNameAndLineNum, withClassName, withMethodName)
        }
    }

    override fun e(throwable: Throwable?,
                   extraMessage: String?,
                   withThreadName: Boolean?) {
        runIfIsLoggingOn { logger.e(throwable, extraMessage, withThreadName) }
    }

    override fun <AnyT> e(anything: AnyT?,
                          withThreadName: Boolean?,
                          withFileNameAndLineNum: Boolean?,
                          withClassName: Boolean?,
                          withMethodName: Boolean?) {
        runIfIsLoggingOn {
            logger.e(anything,
                    withThreadName,
                    withFileNameAndLineNum,
                    withClassName,
                    withMethodName)
        }
    }

    override fun wtf(msg: String?,
                     withThreadName: Boolean?,
                     withFileNameAndLineNum: Boolean?,
                     withClassName: Boolean?,
                     withMethodName: Boolean?) {
        runIfIsLoggingOn {
            logger.wtf(msg, withThreadName, withFileNameAndLineNum, withClassName, withMethodName)
        }
    }

    override fun wtf(throwable: Throwable?,
                     extraMessage: String?,
                     withThreadName: Boolean?) {
        runIfIsLoggingOn { logger.wtf(throwable, extraMessage, withThreadName) }
    }

    override fun <AnyT> wtf(anything: AnyT?,
                            withThreadName: Boolean?,
                            withFileNameAndLineNum: Boolean?,
                            withClassName: Boolean?,
                            withMethodName: Boolean?) {
        runIfIsLoggingOn {
            logger.wtf(anything,
                    withThreadName,
                    withFileNameAndLineNum,
                    withClassName,
                    withMethodName)
        }
    }

    private fun runIfIsLoggingOn(block: () -> Unit) = runIf(shouldLog) { block() }
}