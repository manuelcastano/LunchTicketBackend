package com.example.lunchticketbackend.service

import com.example.lunchticketbackend.entity.Restaurant
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

}