package com.lelo.sell.cars

data class Car(
    val id: Int, val type: String, val model: String
) {

    override fun toString() = "Car [$id-$type-$model]"

    init {
        require(type.isNotBlank())
        require(model.isNotBlank())
        require(id > 0)
    }

    class Request(
        private val type: String, private val model: String
    ) {
        fun toCar(id: Int) = Car(id, this.type, this.model)
    }

    data class AccessEvent(val car: Car)
    data class CreatedEvent(val car: Car)
    data class UpdatedEvent(val car: Car)

    class Response(
        val id: Int, val type: String, val model: String
    ) {
        constructor(car: Car) : this(type = car.type, model = car.model, id = car.id)
    }
}

