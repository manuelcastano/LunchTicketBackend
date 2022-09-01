package com.example.lunchticketbackend.controller

import com.example.lunchticketbackend.model.AddScholarship
import com.example.lunchticketbackend.model.BooleanResponse
import com.example.lunchticketbackend.service.StudentServiceImplementation
import com.example.lunchticketbackend.service.StudentServiceInterface
import com.google.gson.Gson
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
class StudentControllerImplementation(val studentService: StudentServiceInterface): StudentControllerInterface{

    @PostMapping("/addScholarship")
    override fun addScholarship(@RequestBody body: String): BooleanResponse{
        var json = Gson()
        var toAdd: AddScholarship = json.fromJson(body, AddScholarship::class.java)
        return studentService.addScholarship(toAdd.document, toAdd.scholarshipName)
    }
}