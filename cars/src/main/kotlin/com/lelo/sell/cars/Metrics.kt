package com.lelo.sell.cars

import io.micrometer.core.instrument.MeterRegistry
import java.util.concurrent.atomic.AtomicInteger
import org.springframework.stereotype.Service

@Service
class Metrics(registry: MeterRegistry) {
    val carCounter = registry.counter("cars_counter")
    val carGauge = registry.gauge("cars_gauge", AtomicInteger(0))

    fun incrementCar() = carCounter.apply {
        increment()
        carGauge?.set(count().toInt())
    }
}