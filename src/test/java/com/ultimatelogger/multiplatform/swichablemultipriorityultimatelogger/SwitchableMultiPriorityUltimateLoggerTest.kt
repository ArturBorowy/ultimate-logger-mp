package com.ultimatelogger.multiplatform.swichablemultipriorityultimatelogger

import com.nhaarman.mockitokotlin2.mock
import com.ultimatelogger.multiplatform.SwitchableMultiPriorityUltimateLogger
import com.ultimatelogger.multiplatform.data.TagSettingsRepository
import com.ultimatelogger.multiplatform.output.MultiPriorityLogger
import com.ultimatelogger.multiplatform.tag.provider.string.StringTagProvider
import com.ultimatelogger.multiplatform.tag.provider.throwable.ThrowableTagProvider

internal abstract class SwitchableMultiPriorityUltimateLoggerTest {

    protected val mockMultiPriorityLogger: MultiPriorityLogger = mock()
    protected val mockStringTagProvider: StringTagProvider = mock()
    protected val mockThrowableTagProvider: ThrowableTagProvider = mock()
    protected val tagSettingsRepository: TagSettingsRepository = mock()

    protected val switchableMultiPriorityUltimateLogger = SwitchableMultiPriorityUltimateLogger(
        mockMultiPriorityLogger,
        mockStringTagProvider,
        mockThrowableTagProvider,
        tagSettingsRepository
    )
}