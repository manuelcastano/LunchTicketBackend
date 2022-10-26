package com.example.lunchticketbackend.controller

import com.example.lunchticketbackend.entity.Lunch
import com.example.lunchticketbackend.entity.Student
import com.example.lunchticketbackend.model.BooleanResponse
import org.springframework.core.io.Resource
import org.springframework.http.ResponseEntity
import org.springframework.web.multipart.MultipartFile

interface StudentControllerInterface {

    fun addScholarship(body: String): BooleanResponse
    fun deactivateScholarship(body: String): BooleanResponse
    fun editScholarship(body: String): BooleanResponse
    fun deactivateStudent(body: String): BooleanResponse
    fun getAllStudents(): List<Student>
    fun addStudent(body: String): BooleanResponse
    fun getStudent(body: String): Student?
    fun uploadPicture(body: String, image: MultipartFile): BooleanResponse
    fun getImage(body: String): ResponseEntity<Resource?>?
    fun hasImageUpdated(body: String): BooleanResponse
    fun lastLunch(body: String): Lunch?
}