package com.lelo.sell

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.lelo.sell"])
class CarsApplication

fun main(args: Array<String>) {
    runApplication<CarsApplication>(*args)
}