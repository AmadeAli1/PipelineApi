package com.amade.dev.pipelineapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.io.File

@SpringBootApplication
class PipelineApiApplication
fun main(args: Array<String>) {
    runApplication<PipelineApiApplication>(*args)
}
