package com.ultimatelogger.multiplatform

import com.ultimatelogger.multiplatform.output.MultiPriorityLogger
import com.ultimatelogger.multiplatform.tag.provider.string.StringTagProvider
import com.ultimatelogger.multiplatform.tag.provider.throwable.ThrowableTagProvider

internal class SwitchableMultiPriorityUltimateLogger(
        private val logger: MultiPriorityLogger,
        private val stringTagProvider: StringTagProvider,
        private val throwableTagProvider: ThrowableTagProvider
) : UltimateLogger {

    override fun v(msg: String?,
                   withThreadName: Boolean?,
                   withFileNameAndLineNum: Boolean?,
                   withClassName: Boolean?,
                   withMethodName: Boolean?) {
        logger.v(
                getTagForString(withThreadName,
                        withFileNameAndLineNum,
                        withClassName,
                        withMethodName),
                msg)
    }

    override fun v(throwable: Throwable?,
                   extraMessage: String?,
                   withThreadName: Boolean?) {
        logger.v(getTagForThrowable(withThreadName), extraMessage, throwable)
    }

    override fun <AnyT> v(anything: AnyT?,
                          withThreadName: Boolean?,
                          withFileNameAndLineNum: Boolean?,
                          withClassName: Boolean?,
                          withMethodName: Boolean?) {
        v(anything.toString(), 
                withThreadName, 
                withFileNameAndLineNum,
                withClassName, 
                withMethodName)
    }

    override fun d(msg: String?,
                   withThreadName: Boolean?,
                   withFileNameAndLineNum: Boolean?,
                   withClassName: Boolean?,
                   withMethodName: Boolean?) {
        logger.d(
                getTagForString(withThreadName,
                        withFileNameAndLineNum,
                        withClassName,
                        withMethodName),
                msg)
    }

    override fun d(throwable: Throwable?,
                   extraMessage: String?,
                   withThreadName: Boolean?) {
        logger.d(getTagForThrowable(withThreadName), extraMessage, throwable)
    }

    override fun <AnyT> d(anything: AnyT?,
                          withThreadName: Boolean?,
                          withFileNameAndLineNum: Boolean?,
                          withClassName: Boolean?,
                          withMethodName: Boolean?) {
        d(anything.toString(), 
                withThreadName, 
                withFileNameAndLineNum,
                withClassName, 
                withMethodName)
    }

    override fun i(msg: String?,
                   withThreadName: Boolean?,
                   withFileNameAndLineNum: Boolean?,
                   withClassName: Boolean?,
                   withMethodName: Boolean?) {
        logger.i(
                getTagForString(withThreadName,
                        withFileNameAndLineNum,
                        withClassName,
                        withMethodName),
                msg)
    }

    override fun i(throwable: Throwable?,
                   extraMessage: String?,
                   withThreadName: Boolean?) {
        logger.i(getTagForThrowable(withThreadName), extraMessage, throwable)
    }

    override fun <AnyT> i(anything: AnyT?,
                          withThreadName: Boolean?,
                          withFileNameAndLineNum: Boolean?,
                          withClassName: Boolean?,
                          withMethodName: Boolean?) {
        i(anything.toString(), 
                withThreadName, 
                withFileNameAndLineNum,
                withClassName, 
                withMethodName)
    }

    override fun w(msg: String?,
                   withThreadName: Boolean?,
                   withFileNameAndLineNum: Boolean?,
                   withClassName: Boolean?,
                   withMethodName: Boolean?) {
        logger.w(
                getTagForString(withThreadName,
                        withFileNameAndLineNum,
                        withClassName,
                        withMethodName),
                msg)
    }

    override fun w(throwable: Throwable?,
                   extraMessage: String?,
                   withThreadName: Boolean?) {
        logger.w(getTagForThrowable(withThreadName), extraMessage, throwable)
    }

    override fun <AnyT> w(anything: AnyT?,
                          withThreadName: Boolean?,
                          withFileNameAndLineNum: Boolean?,
                          withClassName: Boolean?,
                          withMethodName: Boolean?) {
        w(anything.toString(), 
                withThreadName, 
                withFileNameAndLineNum,
                withClassName, 
                withMethodName)
    }

    override fun e(msg: String?,
                   withThreadName: Boolean?,
                   withFileNameAndLineNum: Boolean?,
                   withClassName: Boolean?,
                   withMethodName: Boolean?) {
        logger.e(
                getTagForString(withThreadName,
                        withFileNameAndLineNum,
                        withClassName,
                        withMethodName),
                msg)
    }

    override fun e(throwable: Throwable?,
                   extraMessage: String?,
                   withThreadName: Boolean?) {
        logger.e(getTagForThrowable(withThreadName), extraMessage, throwable)
    }

    override fun <AnyT> e(anything: AnyT?,
                          withThreadName: Boolean?,
                          withFileNameAndLineNum: Boolean?,
                          withClassName: Boolean?,
                          withMethodName: Boolean?) {
        e(anything.toString(), 
                withThreadName, 
                withFileNameAndLineNum,
                withClassName, 
                withMethodName)
    }

    override fun wtf(msg: String?,
                     withThreadName: Boolean?,
                     withFileNameAndLineNum: Boolean?,
                     withClassName: Boolean?,
                     withMethodName: Boolean?) {
        logger.wtf(
                getTagForString(withThreadName,
                        withFileNameAndLineNum,
                        withClassName,
                        withMethodName),
                msg)
    }

    override fun wtf(throwable: Throwable?,
                     extraMessage: String?,
                     withThreadName: Boolean?) {
        logger.wtf(getTagForThrowable(withThreadName), extraMessage, throwable)
    }

    override fun <AnyT> wtf(anything: AnyT?,
                            withThreadName: Boolean?,
                            withFileNameAndLineNum: Boolean?,
                            withClassName: Boolean?,
                            withMethodName: Boolean?) {
        wtf(anything.toString(), 
                withThreadName, 
                withFileNameAndLineNum,
                withClassName, 
                withMethodName)
    }

    private fun getTagForString(withThreadName: Boolean?,
                                withFileNameAndLineNum: Boolean?,
                                withClassName: Boolean?,
                                withMethodName: Boolean?) =
            stringTagProvider.provide(withThreadName,
                    withFileNameAndLineNum,
                    withClassName,
                    withMethodName)

    private fun getTagForThrowable(withThreadName: Boolean?) =
            throwableTagProvider.provide(withThreadName)
}