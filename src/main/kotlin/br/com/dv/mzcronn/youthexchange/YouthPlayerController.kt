package br.com.dv.mzcronn.youthexchange

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class YouthPlayerController(private val azureTableStorageService: AzureTableService) {

    @PostMapping("/save")
    fun saveYouthExchangeData(@RequestBody data: YouthExchange): ResponseEntity<String> {
        azureTableStorageService.insertOrUpdateEntity(data)
        return ResponseEntity.ok("Data saved successfully to Azure Table Storage")
    }

}
