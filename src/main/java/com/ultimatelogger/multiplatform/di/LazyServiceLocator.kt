package com.ultimatelogger.multiplatform.di

import com.ultimatelogger.multiplatform.di.util.named
import com.ultimatelogger.multiplatform.di.util.toKoinParameters
import com.ultimatelogger.multiplatform.exception.UltimateLoggerNotInitializedException
import org.koin.core.Koin

internal object LazyServiceLocator {

    var koin: Koin? = null

    private val koinPrivate: Koin
        get() = koin ?: throw UltimateLoggerNotInitializedException()

    inline fun <reified DependencyT> getDependency(qualifierString: String?) =
            getDependency<DependencyT>(qualifierString, {})

    inline fun <reified DependencyT> getDependency(vararg parametersGetter: () -> Any?) =
            getDependency<DependencyT>(qualifierString = null, parametersGetter = *parametersGetter)

    inline fun <reified DependencyT> getDependency(qualifierString: String? = null,
                                                   vararg parametersGetter: () -> Any? = arrayOf()) =
            lazy {
                koinPrivate.get<DependencyT>(named(qualifierString)) {
                    parametersGetter.toKoinParameters()
                }
            }
}