package com.lelo.sell.offers

import com.lelo.sell.offers.Offer.Request
import com.lelo.sell.offers.sources.CarsExternalSourceService
import org.springframework.stereotype.Service

@Service
class Service(
    val metrics: Metrics, val carService: CarsExternalSourceService
) {

    private val offers = mutableListOf<Offer>()

    fun save(request: Request, id: Int = offers.size + 1) =
        offers
            .add(request.toOffer(id, carService.find(request.carId)))
            .also { metrics.incrementOffer() }

    fun list() =
        offers
            .toList()
            .sortedBy { it.id }
            .also { metrics.incrementOffer() }
}