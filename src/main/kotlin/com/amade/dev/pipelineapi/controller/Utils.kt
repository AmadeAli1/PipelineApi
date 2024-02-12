package com.amade.dev.pipelineapi.controller

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.core.io.buffer.DataBufferUtils
import org.springframework.http.codec.multipart.FilePart
import org.springframework.util.StringUtils

suspend fun FilePart.toByteArray(): ByteArray = withContext(Dispatchers.IO) {
    DataBufferUtils.join(this@toByteArray.content()).map { it.asByteBuffer().array() }.block()!!
}

fun FilePart.fileName(): String {
    return StringUtils.cleanPath(this.filename())
}