package com.example.lunchticketbackend.service

import com.example.lunchticketbackend.entity.Restaurant

interface RestaurantServiceInterface {
    fun findAll():List<Restaurant>
    fun findRestById(restaurantId:Long):Restaurant
}