package com.lelo.sell.cars

import com.lelo.sell.cars.Car.Request
import com.lelo.sell.cars.Car.Response
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CarsController(val service: CarService) {

    @GetMapping("/cars")
    fun list() = service.list().map { Response(it) }

    @GetMapping("/cars/{id}")
    fun get(@PathVariable id: Int) =
        service.get(id)

    @PostMapping("/cars")
    fun new(@RequestBody newCar: Request) =
        service.save(newCar)

    @PutMapping("/cars/{id}")
    fun new(@PathVariable id: Int, @RequestBody updatedCar: Request) =
        service.update(id, updatedCar)
}

@Service
class CarService(val metrics: Metrics) {

    private val cars = mutableListOf<Car>()

    fun save(request: Request, id: Int = cars.size + 1) =
        cars
            .add(request.toCar(id))
            .also { metrics.incrementCar() }

    fun update(id: Int, request: Request) =
        cars
            .removeIf { it.id == id }
            .also { this.save(request, id) }

    fun list() =
        cars
            .toList()
            .sortedBy { it.id }
            .also { metrics.incrementCar() }

    fun get(id: Int) =
        cars
            .first { it.id == id }
            .also { metrics.incrementCar() }
}


class Car(val id: Int, val type: String, val model: String) {

    class Request(val type: String, val model: String) {
        fun toCar(id: Int) = Car(id, this.type, this.model)
    }

    class Response(val id: Int, val type: String, val model: String) {
        constructor(car: Car) : this(type = car.type, model = car.model, id = car.id)
    }
}

