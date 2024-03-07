package br.com.dv.mzcronn.common

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import jakarta.annotation.PostConstruct
import org.springframework.core.io.ResourceLoader
import org.springframework.stereotype.Service

@Service
class CountryDataService(private val resourceLoader: ResourceLoader) {

    private lateinit var countryMap: Map<String, String>

    @PostConstruct
    fun init() {
        val mapper = jacksonObjectMapper()
        val resource = resourceLoader.getResource("classpath:countries.json")
        countryMap = mapper.readValue(resource.inputStream, object : TypeReference<Map<String, String>>() {})
    }

    fun getCountryMap(): Map<String, String> = countryMap

}
