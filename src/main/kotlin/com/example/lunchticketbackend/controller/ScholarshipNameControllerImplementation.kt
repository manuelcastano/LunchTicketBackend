package com.example.lunchticketbackend.controller

import com.example.lunchticketbackend.entity.Scholarship_name
import com.example.lunchticketbackend.service.ScholarshipNameServiceInterface
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
class ScholarshipNameControllerImplementation(val scholarshipNameService: ScholarshipNameServiceInterface): ScholarshipNameControllerInterface {

    @GetMapping("/scholarships")
    override fun getAllScholarships(): List<Scholarship_name> {
        return scholarshipNameService.getAllScholarships()
    }
}