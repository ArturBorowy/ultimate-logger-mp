package com.ultimatelogger.multiplatform.di

import com.ultimatelogger.multiplatform.SwitchableMultiPriorityUltimateLogger
import com.ultimatelogger.multiplatform.UltimateLogger
import com.ultimatelogger.multiplatform.data.TagSettingsRepository
import com.ultimatelogger.multiplatform.output.MultiPriorityLogger
import com.ultimatelogger.multiplatform.tag.builder.TagDataTagBuilder
import com.ultimatelogger.multiplatform.tag.builder.TagDataTagBuilderWithDefaultSettings
import com.ultimatelogger.multiplatform.tag.dataprovider.TagDataConverter
import com.ultimatelogger.multiplatform.tag.dataprovider.TagDataProvider
import com.ultimatelogger.multiplatform.tag.dataprovider.stacktrace.*
import com.ultimatelogger.multiplatform.tag.provider.string.StringTagProvider
import com.ultimatelogger.multiplatform.tag.provider.string.StringTagProviderWithTagData
import com.ultimatelogger.multiplatform.tag.provider.throwable.ThrowableTagProvider
import com.ultimatelogger.multiplatform.tag.provider.throwable.ThrowableTagProviderFromStringTagProvider
import org.koin.dsl.module

internal fun applicationModule(logOutput: MultiPriorityLogger) = module {
    single<TagDataTagBuilder> { TagDataTagBuilderWithDefaultSettings(get()) }

    single<StringTagProvider> { StringTagProviderWithTagData(get(), get()) }
    single<ThrowableTagProvider> { ThrowableTagProviderFromStringTagProvider(get()) }

    single { TagDataConverter() }
    single { TagSettingsRepository() }

    single<StackTraceProvider> { StackTraceFromThreadProvider() }

    single<StackTraceElementProvider> { ClassIgnorableStackTraceElementProvider(get(), get()) }
    single<TagDataProvider> { StackTraceTagDataProvider(get(), get()) }

    single { logOutput }
    single<UltimateLogger> { SwitchableMultiPriorityUltimateLogger(get(), get(), get()) }
}