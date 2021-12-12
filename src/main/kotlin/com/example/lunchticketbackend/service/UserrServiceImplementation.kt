package com.example.lunchticketbackend.service

import com.example.lunchticketbackend.entity.Userr
import com.example.lunchticketbackend.repository.UserrRepo
import org.springframework.stereotype.Service

@Service
class UserrServiceImplementation(val userRepo: UserrRepo):UserrServiceInterface {
    override fun findAll(): List<Userr> {
        return userRepo.findAll() as List<Userr>
    }
}