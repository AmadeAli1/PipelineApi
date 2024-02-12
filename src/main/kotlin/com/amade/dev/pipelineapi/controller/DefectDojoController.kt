package com.amade.dev.pipelineapi.controller

import io.securecodebox.persistence.defectdojo.ScanType
import io.securecodebox.persistence.defectdojo.model.Engagement
import io.securecodebox.persistence.defectdojo.model.ProductType
import io.securecodebox.persistence.defectdojo.model.ScanFile
import io.securecodebox.persistence.defectdojo.model.TestType
import io.securecodebox.persistence.defectdojo.service.EngagementService
import io.securecodebox.persistence.defectdojo.service.ImportScanService
import io.securecodebox.persistence.defectdojo.service.ImportScanService2
import io.securecodebox.persistence.defectdojo.service.ProductService
import io.securecodebox.persistence.defectdojo.service.ProductTypeService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.http.codec.multipart.FilePart
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.RestController
import java.util.Date

@RequestMapping("/api/defect-dojo")
@RestController
class DefectDojoController(
    private val productService: ProductService,
    private val engagementService: EngagementService,
    private val importScanService: ImportScanService2,
) {


    @PostMapping("/import-scan")
    suspend fun sendScanning(
        @RequestPart("file") file: FilePart,
    ) {
        val fileContent = withContext(Dispatchers.IO) { file.toByteArray().decodeToString() }
        val scanFile = ScanFile(fileContent)

        //engagementService.create(Engagement())

        println(engagementService.search())
        importScanService.importScan(
            scanFile,
            1,
            1,
            "2024-02-11",
            ScanType.GIT_LAB_SAST_REPORT,
            1
        )
    }

}


data class ImportScan(
    val engagementId: Int,
    val lead: Int,
    val currentDate: String,
    val scanType: ScanType,
    val testType: String,
)