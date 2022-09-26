package com.example.lunchticketbackend.service

import com.example.lunchticketbackend.entity.Scholarship_name
import com.example.lunchticketbackend.model.BooleanResponse

interface ScholarshipNameServiceInterface {

    fun getAllScholarships(): List<Scholarship_name>
    fun addNewScholarship(name: String): BooleanResponse
}