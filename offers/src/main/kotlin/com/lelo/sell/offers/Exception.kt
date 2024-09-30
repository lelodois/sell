package com.lelo.sell.offers

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class CarNotFoundException(id: Int) : RuntimeException("Car: [$id] not found to offer")