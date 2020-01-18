package com.ultimatelogger.multiplatform.tag.dataprovider

internal class TagDataConverter {

    companion object {
        private const val FILE_NAME_MISSING = "UnknownFile"
    }

    fun fromStackTraceElement(stackTraceElement: StackTraceElement) =
            TagData(stackTraceElement.fileName ?: FILE_NAME_MISSING,
                    stackTraceElement.className,
                    stackTraceElement.methodName,
                    stackTraceElement.lineNumber.toString())
}
