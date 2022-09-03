package com.example.lunchticketbackend.service

import com.example.lunchticketbackend.model.BooleanResponse

interface StudentServiceInterface {

    fun addScholarship(document: String, scholarshipName: String): BooleanResponse
    fun deactivateScholarship(username: String): BooleanResponse
}