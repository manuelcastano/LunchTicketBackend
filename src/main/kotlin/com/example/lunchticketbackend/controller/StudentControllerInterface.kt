package com.example.lunchticketbackend.controller

import com.example.lunchticketbackend.model.BooleanResponse

interface StudentControllerInterface {

    fun addScholarship(body: String): BooleanResponse
    fun deactivateScholarship(body: String): BooleanResponse
    fun editScholarship(body: String): BooleanResponse
    fun deactivateStudent(body: String): BooleanResponse
}