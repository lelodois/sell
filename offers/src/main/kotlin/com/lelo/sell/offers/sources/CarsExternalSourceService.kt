package com.lelo.sell.offers.sources

import com.google.gson.Gson
import org.apache.http.client.fluent.Request
import org.springframework.stereotype.Service

@Service
class CarsExternalSourceService(val properties: CarsExternalSourceProperties) {

    fun find(carId: Int): Car =
        Request
            .Get("${properties.baseUrl}/cards/${carId}")
            .execute()
            .returnContent()
            .asString()
            .let { Gson().fromJson(it, Car::class.java) }
}

class Car(val id: Int, val type: String, val model: String) {
    class Response(val id: Int, val type: String, val model: String) {
        constructor(car: Car) : this(type = car.type, model = car.model, id = car.id)
    }
}