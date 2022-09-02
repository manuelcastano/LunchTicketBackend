package com.example.lunchticketbackend.controller

import com.example.lunchticketbackend.entity.Restaurant
import com.example.lunchticketbackend.model.BooleanResponse

interface RestaurantControllerInterface {
    fun getRestaurants():List<Restaurant>
    fun addRestaurant(body: String): BooleanResponse
}