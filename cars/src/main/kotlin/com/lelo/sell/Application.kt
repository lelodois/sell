package com.lelo.sell

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.lelo.sell"])
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}