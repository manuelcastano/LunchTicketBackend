package com.example.lunchticketbackend.service

import com.example.lunchticketbackend.entity.Student
import com.example.lunchticketbackend.model.BooleanResponse
import com.example.lunchticketbackend.model.EditScholarship
import org.springframework.core.io.Resource
import org.springframework.http.ResponseEntity
import org.springframework.web.multipart.MultipartFile

interface StudentServiceInterface {

    fun addScholarship(document: String, scholarshipName: String): BooleanResponse
    fun deactivateScholarship(username: String): BooleanResponse
    fun editScholarship(info: EditScholarship): BooleanResponse
    fun findAll():List<Student>
    fun addStudent(student: com.example.lunchticketbackend.model.Student): BooleanResponse
    fun findStudentByUsername(document: String): Student?
    fun uploadPicture(document: String, image: MultipartFile): BooleanResponse
    fun getImage(document: String): ResponseEntity<Resource?>?
    fun hasImageUpdated(document: String): BooleanResponse
}