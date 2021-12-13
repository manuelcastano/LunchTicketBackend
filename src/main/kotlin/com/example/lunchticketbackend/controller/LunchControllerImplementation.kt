package com.example.lunchticketbackend.controller

import com.example.lunchticketbackend.entity.Lunch
import com.example.lunchticketbackend.service.LunchServiceInterface
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class LunchControllerImplementation(private val lunchService: LunchServiceInterface):LunchControllerInterface {

    @GetMapping("/lunches")
    override fun getLunches(): List<Lunch> {
        return lunchService.findAll()
    }

    @PostMapping
    override fun saveLunch(): Boolean {
        TODO("Not yet implemented")
    }
}