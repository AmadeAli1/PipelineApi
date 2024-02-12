package com.amade.dev.pipelineapi.configuration

import io.securecodebox.persistence.defectdojo.config.Config
import io.securecodebox.persistence.defectdojo.service.EngagementService
import io.securecodebox.persistence.defectdojo.service.ImportScanService2
import io.securecodebox.persistence.defectdojo.service.ProductService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import org.springframework.core.env.get

@Configuration
class DefectDojoConfiguration {

    @Bean("defect-dojo-config")
    fun defectDojoConfiguration(environment: Environment): Config {

        return Config(environment["defect-dojo-url"]!!, environment["defect-dojo-apiKey"]!!)
    }

    @Bean
    fun defectDojoProductService(config: Config): ProductService {
        return ProductService(config)
    }


    @Bean
    fun defectDojoImportService(config: Config): ImportScanService2 {
        return ImportScanService2(config)
    }

    @Bean
    fun defectDojoEngage(config: Config): EngagementService {
        return EngagementService(config)
    }


}