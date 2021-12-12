package com.example.lunchticketbackend.service

import com.example.lunchticketbackend.entity.Rolee
import com.example.lunchticketbackend.repository.RoleeRepo
import org.springframework.stereotype.Service

@Service
class RoleeServiceImplementation(val roleRepo: RoleeRepo):RoleeServiceInterface {
    override fun findAll(): List<Rolee> {
        return roleRepo.findAll() as List<Rolee>
    }
}