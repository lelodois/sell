package com.lelo.sell.offers.sources

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties("cars")
class CarsExternalSourceProperties{
    lateinit var baseUrl: String
}
