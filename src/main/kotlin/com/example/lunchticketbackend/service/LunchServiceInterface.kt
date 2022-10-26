package com.example.lunchticketbackend.service

import com.example.lunchticketbackend.entity.Lunch
import com.example.lunchticketbackend.entity.Restaurant
import com.example.lunchticketbackend.model.BooleanResponse

interface LunchServiceInterface {
    fun findAll():List<Lunch>
    fun findLunchById(lunchId:Long):Lunch
    fun create(persCode : String, restNIT: String, timestamp: Long)
    fun saveLunch(persCode: String, restNIT: String, accepted: String): BooleanResponse
    fun inTime(): Boolean
    fun hasAlreadyLunch(document: String): BooleanResponse
    fun lastLunchInTheDay(document: String): Lunch?
}