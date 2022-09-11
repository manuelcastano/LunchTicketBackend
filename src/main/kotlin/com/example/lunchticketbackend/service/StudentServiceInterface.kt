package com.example.lunchticketbackend.service

import com.example.lunchticketbackend.entity.Student
import com.example.lunchticketbackend.model.BooleanResponse
import com.example.lunchticketbackend.model.EditScholarship

interface StudentServiceInterface {

    fun addScholarship(document: String, scholarshipName: String): BooleanResponse
    fun deactivateScholarship(username: String): BooleanResponse
    fun editScholarship(info: EditScholarship): BooleanResponse
    fun findAll():List<Student>
    fun addStudent(student: com.example.lunchticketbackend.model.Student): BooleanResponse
}