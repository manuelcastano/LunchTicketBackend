package com.example.lunchticketbackend.controller

import com.example.lunchticketbackend.entity.Restaurant
import com.example.lunchticketbackend.service.RestaurantServiceInterface
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RestaurantControllerImplementantion(val restService: RestaurantServiceInterface): RestaurantControllerInterface {

    @GetMapping("/restaurants")
    override fun getRestaurants(): List<Restaurant> {
        return restService.findAll()
    }
}