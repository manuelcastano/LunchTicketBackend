package com.example.lunchticketbackend.service

import com.example.lunchticketbackend.entity.Lunch
import com.example.lunchticketbackend.repository.LunchRepo
import org.springframework.stereotype.Service

@Service
class LunchServiceImplementation(val lunchRepo: LunchRepo):LunchServiceInterface {

    override fun findAll(): List<Lunch> {
        return lunchRepo.findAll() as List<Lunch>
    }

    override fun findLunchById(lunchId: Long): Lunch {
        return lunchRepo.findById(lunchId).get()
    }
}