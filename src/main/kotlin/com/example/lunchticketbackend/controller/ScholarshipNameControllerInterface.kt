package com.example.lunchticketbackend.controller

import com.example.lunchticketbackend.entity.Scholarship_name
import com.example.lunchticketbackend.model.BooleanResponse

interface ScholarshipNameControllerInterface {

    fun getAllScholarships(): List<Scholarship_name>
    fun addNewScholarship(body: String): BooleanResponse
    fun deleteScholarship(body: String): BooleanResponse
}