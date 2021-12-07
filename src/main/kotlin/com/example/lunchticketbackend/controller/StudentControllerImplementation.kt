package com.example.lunchticketbackend.controller

import com.example.lunchticketbackend.entity.Student
import com.example.lunchticketbackend.service.StudentServiceInterface
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class StudentControllerImplementation(val studService:StudentServiceInterface):StudentControllerInterface{

    @GetMapping("/students")
    override fun getStudents(): List<Student> {
        return studService.findAll()
    }
}