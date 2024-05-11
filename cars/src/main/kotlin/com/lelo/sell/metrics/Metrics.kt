package com.lelo.sell.metrics

import com.lelo.sell.cars.Car.AccessEvent
import com.lelo.sell.cars.Car.CreatedEvent
import com.lelo.sell.cars.Car.UpdatedEvent
import io.micrometer.core.instrument.MeterRegistry
import java.util.concurrent.atomic.AtomicInteger
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Service

@Service
class Metrics(registry: MeterRegistry) {

    val logger: Logger = LoggerFactory.getLogger(Metrics::class.java)

    val carCreateCounter = registry.counter("cars_modify_counter")
    val carCreateGauge = registry.gauge("cars_modify_gauge", AtomicInteger(0))

    val carGetCounter = registry.counter("cars_get_counter")
    val carGetGauge = registry.gauge("cars_get_gauge", AtomicInteger(0))

    @EventListener
    fun createListener(event: CreatedEvent) {
        logger.info("create listener for: $event")
        carCreateCounter.apply {
            increment()
            carCreateGauge?.set(count().toInt())
        }
        logger.info("New counter ${carCreateCounter.count()}")
    }

    @EventListener
    fun updateListener(event: UpdatedEvent) {
        logger.info("update listener for: $event")
    }

    @EventListener
    fun accessListener(event: AccessEvent) {
        logger.info("access listener for: $event")
        carGetCounter.apply {
            increment()
            carGetGauge?.set(count().toInt())
        }
        logger.info("Access counter ${carGetCounter.count()}")
    }
}