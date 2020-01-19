package com.ultimatelogger.multiplatform.tag.builder

import com.ultimatelogger.multiplatform.tag.dataprovider.TagData

internal interface TagDataTagBuilder {

    fun build(tagData: TagData?,
              withThreadName: Boolean?,
              withFileNameAndLineNum: Boolean?,
              withClassName: Boolean?,
              withMethodName: Boolean?): String
}