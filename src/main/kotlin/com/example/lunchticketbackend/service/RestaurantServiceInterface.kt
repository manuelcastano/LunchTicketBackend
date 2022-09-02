package com.example.lunchticketbackend.service

import com.example.lunchticketbackend.entity.Restaurant
import com.example.lunchticketbackend.model.BooleanResponse

interface RestaurantServiceInterface {
    fun findAll():List<Restaurant>
    fun findRestById(restaurantId:Long):Restaurant
    fun addRestaurant(restaurant: com.example.lunchticketbackend.model.Restaurant): BooleanResponse
}