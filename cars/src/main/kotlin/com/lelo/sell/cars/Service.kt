package com.lelo.sell.cars

import com.lelo.sell.cars.Car.Request
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service

@Service
class Service(val publisher: ApplicationEventPublisher) {

    private val cars = mutableListOf<Car>()

    fun save(request: Request) =
        request.toCar(cars.size + 1)
            .also { cars.add(it) }
            .also {
                publisher.publishEvent(Car.CreatedEvent(it))
            }

    fun update(id: Int, request: Request): Car {
        cars.first { it.id == id }.let { cars.remove(it) }

        return request.toCar(id).let {
            cars.add(it)
            publisher.publishEvent(Car.UpdatedEvent(it))
            it
        }
    }

    fun list() =
        cars.toList()
            .map {
                publisher.publishEvent(Car.AccessEvent(it))
                it
            }.sortedBy { it.id }

    fun get(id: Int) =
        cars.firstOrNull { it.id == id }
            ?.also {
                publisher.publishEvent(Car.AccessEvent(it))
            } ?: run { throw NotFoundException(id) }
}