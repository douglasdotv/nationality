package br.com.dv.mzcronn

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class MzcronnApplication

fun main(args: Array<String>) {
    runApplication<MzcronnApplication>(*args)
}
