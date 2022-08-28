package com.example.lunchticketbackend.controller

import com.example.lunchticketbackend.model.BooleanResponse

interface RolesControllerInterface {
    fun addRole(body: String): BooleanResponse
}