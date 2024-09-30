package com.lelo.sell

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties
class OffersApplication

fun main(args: Array<String>) {
    runApplication<OffersApplication>(*args)
}