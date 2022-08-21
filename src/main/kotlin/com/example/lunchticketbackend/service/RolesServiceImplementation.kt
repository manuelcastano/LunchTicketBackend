package com.example.lunchticketbackend.service

import com.example.lunchticketbackend.entity.Roles
import com.example.lunchticketbackend.repository.RolesRepo
import org.springframework.stereotype.Service

@Service
class RolesServiceImplementation(val rolesRepo: RolesRepo):RolesServiceInterface {
    override fun findAll(): List<Roles> {
        return rolesRepo.findAll() as List<Roles>
    }
}