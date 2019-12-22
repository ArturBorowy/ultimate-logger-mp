package com.ultimatelogger.multiplatform

interface SwitchableUltimateLogger : UltimateLogger {

    var shouldLog: Boolean
}