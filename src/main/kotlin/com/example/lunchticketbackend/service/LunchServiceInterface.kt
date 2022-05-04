package com.example.lunchticketbackend.service

import com.example.lunchticketbackend.entity.Lunch
import com.example.lunchticketbackend.entity.Person
import com.example.lunchticketbackend.entity.Restaurant

interface LunchServiceInterface {
    fun findAll():List<Lunch>
    fun findLunchById(lunchId:Long):Lunch
    fun create(persCode : String, restNIT: String, timestamp: Long): Lunch
    fun saveLunch(persCode: String, restNIT: String)
}