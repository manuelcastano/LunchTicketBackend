package com.example.lunchticketbackend.controller

import com.example.lunchticketbackend.entity.User_type
import com.example.lunchticketbackend.model.BooleanResponse

interface RolesControllerInterface {
    fun addRole(body: String): BooleanResponse
    fun getRoles(body: String): List<User_type>
}