package com.example.lunchticketbackend.controller

import com.example.lunchticketbackend.entity.Employee_R
import com.example.lunchticketbackend.entity.Restaurant
import com.example.lunchticketbackend.model.BooleanResponse

interface RestaurantControllerInterface {
    fun getRestaurants():List<Restaurant>
    fun addRestaurant(body: String): BooleanResponse
    fun findRestaurant(body: String): Restaurant?
    fun deleteRestaurant(body: String): BooleanResponse
    fun deleteRestaurantEmployee(body: String): BooleanResponse
    fun addRestaurantEmployee(body: String): BooleanResponse
    fun getEmployees(body: String): List<Employee_R>?
    fun deactivateRestaurant(body: String): BooleanResponse
}