package com.lelo.sell.cars

import com.lelo.sell.cars.Car.Request
import com.lelo.sell.cars.Car.Response
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("cars")
class Controller(val service: Service) {

    @GetMapping
    fun list() = service.list().map { Response(it) }

    @GetMapping("/{id}")
    fun get(@PathVariable id: Int) = Response(service.get(id))

    @PostMapping
    fun new(@RequestBody newCar: Request) = Response(service.save(newCar))

    @PutMapping("/{id}")
    fun update(@PathVariable id: Int, @RequestBody updatedCar: Request) =
        Response(service.update(id, updatedCar))
}