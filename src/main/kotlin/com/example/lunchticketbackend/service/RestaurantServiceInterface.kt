package com.example.lunchticketbackend.service

import com.example.lunchticketbackend.entity.Employee_R
import com.example.lunchticketbackend.entity.Restaurant
import com.example.lunchticketbackend.model.AddEmployeeR
import com.example.lunchticketbackend.model.BooleanResponse

interface RestaurantServiceInterface {
    fun findAll():List<Restaurant>
    fun findRestById(restaurantId:Long):Restaurant
    fun addRestaurant(restaurant: com.example.lunchticketbackend.model.Restaurant): BooleanResponse
    fun findRestaurantByNit(nit: String): Restaurant?
    fun deleteRestaurant(nit: String): BooleanResponse
    fun deleteRestaurantEmployee(document: String): BooleanResponse
    fun addRestaurantEmployee(info: AddEmployeeR): BooleanResponse
    fun getEmployees(id: String): List<Employee_R>?
    fun deactivateRestaurant(nit: String): BooleanResponse
    fun activateRestaurant(nit: String): BooleanResponse
}