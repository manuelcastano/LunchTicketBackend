package com.example.lunchticketbackend.controller

import com.example.lunchticketbackend.entity.Scholarship_name

interface ScholarshipNameControllerInterface {
    fun getAllScholarships(): List<Scholarship_name>
}