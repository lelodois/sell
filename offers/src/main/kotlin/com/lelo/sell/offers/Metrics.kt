package com.lelo.sell.offers

import io.micrometer.core.instrument.MeterRegistry
import java.util.concurrent.atomic.AtomicInteger
import org.springframework.stereotype.Service

@Service
class Metrics(registry: MeterRegistry) {
    val offerCounter = registry.counter("offer_counter")
    val offerGauge = registry.gauge("offer_gauge", AtomicInteger(0))

    fun incrementOffer() = offerCounter.apply {
        increment()
        offerGauge?.set(count().toInt())
    }
}