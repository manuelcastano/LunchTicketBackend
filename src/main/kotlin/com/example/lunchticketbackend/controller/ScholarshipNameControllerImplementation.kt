package com.example.lunchticketbackend.controller

import com.example.lunchticketbackend.entity.Scholarship_name
import com.example.lunchticketbackend.model.BooleanResponse
import com.example.lunchticketbackend.model.Document
import com.example.lunchticketbackend.model.NewScholarship
import com.example.lunchticketbackend.service.ScholarshipNameServiceInterface
import com.google.gson.Gson
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
class ScholarshipNameControllerImplementation(val scholarshipNameService: ScholarshipNameServiceInterface): ScholarshipNameControllerInterface {

    @GetMapping("/scholarships")
    override fun getAllScholarships(): List<Scholarship_name> {
        return scholarshipNameService.getAllScholarships()
    }

    @PostMapping("/addNewScholarship")
    override fun addNewScholarship(@RequestBody body: String): BooleanResponse {
        var json = Gson()
        var name: String = json.fromJson(body, NewScholarship::class.java).name
        return scholarshipNameService.addNewScholarship(name)
    }

    @PostMapping("/deleteScholarship")
    override fun deleteScholarship(@RequestBody body: String): BooleanResponse {
        var json = Gson()
        var name: String = json.fromJson(body, NewScholarship::class.java).name
        return scholarshipNameService.deleteScholarship(name)
    }
}