package com.example.lunchticketbackend.service

import com.example.lunchticketbackend.entity.Roles

interface RolesServiceInterface {
    fun findAll():List<Roles>
}