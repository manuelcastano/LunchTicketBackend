package com.example.lunchticketbackend.controller

import com.example.lunchticketbackend.entity.Restaurant

interface RestaurantControllerInterface {
    fun getRestaurants():List<Restaurant>
}