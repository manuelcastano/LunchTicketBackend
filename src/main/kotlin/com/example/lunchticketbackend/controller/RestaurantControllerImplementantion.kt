package com.example.lunchticketbackend.controller

import com.example.lunchticketbackend.model.Restaurant
import com.example.lunchticketbackend.entity.Restaurant as Restaurante
import com.example.lunchticketbackend.model.BooleanResponse
import com.example.lunchticketbackend.service.RestaurantServiceInterface
import com.google.gson.Gson
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class RestaurantControllerImplementantion(val restService: RestaurantServiceInterface): RestaurantControllerInterface {

    @GetMapping("/restaurants")
    override fun getRestaurants(): List<Restaurante> {
        return restService.findAll()
    }

    @PostMapping("/addRestaurant")
    override fun addRestaurant(@RequestBody body: String): BooleanResponse {
        var json = Gson()
        var toAdd: Restaurant = json.fromJson(body, Restaurant::class.java)
        return restService.addRestaurant(toAdd)
    }
}