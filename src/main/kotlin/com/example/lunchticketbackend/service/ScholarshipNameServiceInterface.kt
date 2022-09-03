package com.example.lunchticketbackend.service

import com.example.lunchticketbackend.entity.Scholarship_name

interface ScholarshipNameServiceInterface {

    fun getAllScholarships(): List<Scholarship_name>
}