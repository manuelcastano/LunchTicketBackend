package com.example.lunchticketbackend.controller

import com.example.lunchticketbackend.entity.Lunch
import com.example.lunchticketbackend.service.LunchServiceInterface
import org.springframework.web.bind.annotation.GetMapping

class LunchControllerImplementation(val lunchService: LunchServiceInterface):LunchControllerInterface {

    @GetMapping("/lunches")
    override fun getLunches(): List<Lunch> {
        return lunchService.findAll()
    }
}