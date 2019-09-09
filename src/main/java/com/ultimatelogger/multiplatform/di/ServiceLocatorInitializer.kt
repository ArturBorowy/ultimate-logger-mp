package com.ultimatelogger.multiplatform.di

import com.ultimatelogger.multiplatform.output.MultiPriorityLogger
import org.koin.core.KoinApplication

internal object ServiceLocatorInitializer {

    fun init(logOutput: MultiPriorityLogger) {
        val koinApplication = KoinApplication.create()
        koinApplication.printLogger()
        koinApplication.modules(applicationModule(logOutput))
        koinApplication.createEagerInstances()

        LazyServiceLocator.koin = koinApplication.koin
    }

    fun destroy() {
        LazyServiceLocator.koin?.close()
        LazyServiceLocator.koin = null
    }
}