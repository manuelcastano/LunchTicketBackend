package com.example.lunchticketbackend.controller

import com.example.lunchticketbackend.entity.Lunch

interface LunchControllerInterface {
    fun getLunches():List<Lunch>
    fun saveLunch():Boolean
}