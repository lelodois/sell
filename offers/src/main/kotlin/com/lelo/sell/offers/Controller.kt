package com.lelo.sell.offers

import com.lelo.sell.offers.Offer.Request
import com.lelo.sell.offers.Offer.Response
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class OffersController(val service: Service) {

    @GetMapping("/offers")
    fun list() = service.list().map { Response(it) }

    @PostMapping("/offers")
    fun new(@RequestBody newCar: Request) =
        service.save(newCar)
}





