package com.lelo.sell.cars

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class NotFoundException(id: Int) : RuntimeException("Car: [$id] not found")