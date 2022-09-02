package com.example.lunchticketbackend.service

import com.example.lunchticketbackend.entity.Restaurant
import com.example.lunchticketbackend.model.BooleanResponse
import com.example.lunchticketbackend.repository.RestaurantRepo
import org.springframework.stereotype.Service

@Service
class RestaurantServiceImplementation(val restRepo: RestaurantRepo):RestaurantServiceInterface{

    override fun findAll(): List<Restaurant> {
        return restRepo.findAll() as List<Restaurant>
    }

    override fun findRestById(restaurantId: Long): Restaurant {
        return restRepo.findById(restaurantId).get()
    }

    override fun addRestaurant(restaurant: com.example.lunchticketbackend.model.Restaurant): BooleanResponse {
        var rest = Restaurant(0, restaurant.name, restaurant.nit, restaurant.pictureUrl)
        restRepo.save(rest)
        return BooleanResponse(true)
    }

}