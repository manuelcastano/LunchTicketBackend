package com.example.lunchticketbackend.controller

import com.example.lunchticketbackend.model.BooleanResponse

interface StudentControllerInterface {

    fun addScholarship(body: String): BooleanResponse
}