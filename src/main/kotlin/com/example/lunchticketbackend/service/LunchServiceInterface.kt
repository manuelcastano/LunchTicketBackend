package com.example.lunchticketbackend.service

import com.example.lunchticketbackend.entity.Lunch

interface LunchServiceInterface {
    fun findAll():List<Lunch>
    fun findLunchById(lunchId:Long):Lunch
}