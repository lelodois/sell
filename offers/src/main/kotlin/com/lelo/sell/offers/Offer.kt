package com.lelo.sell.offers

import com.lelo.sell.offers.sources.Car
import java.math.BigDecimal
import java.time.LocalDateTime

class Offer(
    val id: Int,
    val occuredAt: LocalDateTime = LocalDateTime.now(),
    val nickName: String,
    val car: Car,
    val price: BigDecimal
) {

    class Request(val nickName: String, val carId: Int, val price: BigDecimal) {
        fun toOffer(id: Int, car: Car) = Offer(
            id = id,
            nickName = this.nickName,
            price = this.price,
            car = car
        )
    }

    class Response(
        val id: Int,
        val nickName: String,
        val price: BigDecimal,
        val car: Car.Response
    ) {
        constructor(offer: Offer) : this(
            id = offer.id,
            price = offer.price,
            nickName = offer.nickName,
            car = Car.Response(offer.car)
        )
    }
}