package com.ultimatelogger.multiplatform.di

import org.koin.core.KoinApplication
import org.koin.core.module.Module

internal object ServiceLocatorInitializer {

    fun init(module: Module) {
        val koinApplication = KoinApplication.create()
        koinApplication.printLogger()
        koinApplication.modules(
            applicationModule()
                .plus(module)
        )
        koinApplication.createEagerInstances()

        LazyServiceLocator.koin = koinApplication.koin
    }

    fun destroy() {
        LazyServiceLocator.koin?.close()
        LazyServiceLocator.koin = null
    }
}