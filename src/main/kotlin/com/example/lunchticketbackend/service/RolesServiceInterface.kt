package com.example.lunchticketbackend.service

import com.example.lunchticketbackend.entity.Employee_R
import com.example.lunchticketbackend.entity.Roles
import com.example.lunchticketbackend.model.BooleanResponse

interface RolesServiceInterface {
    fun findAll():List<Roles>
    fun addRole(document: String, userTypeId: Int): BooleanResponse
}