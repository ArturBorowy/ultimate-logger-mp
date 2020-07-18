package com.ultimatelogger.multiplatform

import com.ultimatelogger.multiplatform.data.TagSettingsRepository
import com.ultimatelogger.multiplatform.di.LazyServiceLocator
import com.ultimatelogger.multiplatform.di.ServiceLocatorInitializer
import com.ultimatelogger.multiplatform.output.LoggingIfIsOnMultiPriorityLogger
import com.ultimatelogger.multiplatform.output.MultiPriorityLogger
import com.ultimatelogger.multiplatform.tag.TagSettings
import org.koin.core.definition.Options
import org.koin.core.module.Module

object MpUltimateLoggerInitializer {

    /**
     * Needed in GenericLoggingExtensions.kt.
     */
    internal var ultimateLogger: UltimateLogger? = null

    fun init(
        shouldLog: Boolean,
        defaultTagSettings: TagSettings,
        ultimateLoggerLazy: Lazy<LoggingIfIsOnMultiPriorityLogger>,
        logOutput: MultiPriorityLogger,
        module: Module = Module(false, true)
    ) {
        initServiceLocator(logOutput, module)
        setDefaultTagSettings(defaultTagSettings)

        ultimateLogger = ultimateLoggerLazy.value
        ultimateLoggerLazy.value.shouldLog = shouldLog
    }

    private fun initServiceLocator(logOutput: MultiPriorityLogger, module: Module) {
        module.declareDefinition(module.single(override = true) { logOutput  }, Options(override = true))
        ServiceLocatorInitializer.init(module)
    }

    private fun setDefaultTagSettings(defaultTagSettings: TagSettings) {
        val tagSettingsRepository: TagSettingsRepository by LazyServiceLocator.getDependency()
        tagSettingsRepository.defaultTagSettings = defaultTagSettings
    }

    fun destroy() = ServiceLocatorInitializer.destroy()
}