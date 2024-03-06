package br.com.dv.mzcronn.openfeign

import feign.RequestInterceptor
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FeignConfig {

    @Value("\${PHPSESSID}")
    private lateinit var phpSessId: String

    @Bean
    fun requestInterceptor(): RequestInterceptor = RequestInterceptor { template ->
        template.header("Cookie", "PHPSESSID=$phpSessId")
    }

}
