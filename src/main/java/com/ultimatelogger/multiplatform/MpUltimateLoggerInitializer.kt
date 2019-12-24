package com.ultimatelogger.multiplatform

import com.ultimatelogger.multiplatform.data.TagSettingsRepository
import com.ultimatelogger.multiplatform.di.LazyServiceLocator
import com.ultimatelogger.multiplatform.di.ServiceLocatorInitializer
import com.ultimatelogger.multiplatform.output.LoggingIfIsOnMultiPriorityLogger
import com.ultimatelogger.multiplatform.output.MultiPriorityLogger
import com.ultimatelogger.multiplatform.tag.TagSettings

object MpUltimateLoggerInitializer {

    /**
     * Needed in GenericLoggingExtensions.kt.
     */
    internal var ultimateLogger: UltimateLogger? = null

    fun init(shouldLog: Boolean,
             defaultTagSettings: TagSettings,
             ultimateLoggerLazy: Lazy<LoggingIfIsOnMultiPriorityLogger>,
             logOutput: MultiPriorityLogger) {
        initServiceLocator(logOutput)
        setDefaultTagSettings(defaultTagSettings)

        ultimateLogger = ultimateLoggerLazy.value
        ultimateLoggerLazy.value.shouldLog = shouldLog
    }

    private fun initServiceLocator(logOutput: MultiPriorityLogger) {
        ServiceLocatorInitializer.init(logOutput)
    }

    private fun setDefaultTagSettings(defaultTagSettings: TagSettings) {
        val tagSettingsRepository: TagSettingsRepository by LazyServiceLocator.getDependency()
        tagSettingsRepository.defaultTagSettings = defaultTagSettings
    }

    fun destroy() = ServiceLocatorInitializer.destroy()
}