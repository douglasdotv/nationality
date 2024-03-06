package br.com.dv.mzcronn

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableFeignClients
@EnableScheduling
class MzcronnApplication

fun main(args: Array<String>) {
    runApplication<MzcronnApplication>(*args)
}
