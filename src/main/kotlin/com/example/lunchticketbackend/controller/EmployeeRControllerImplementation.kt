package com.example.lunchticketbackend.controller

import com.example.lunchticketbackend.entity.Employee_R
import com.example.lunchticketbackend.model.BooleanResponse
import com.example.lunchticketbackend.model.Document
import com.example.lunchticketbackend.model.EditScholarship
import com.example.lunchticketbackend.model.LoginEmployee
import com.example.lunchticketbackend.service.EmployeeRServiceInterface
import com.google.gson.Gson
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class EmployeeRControllerImplementation(val employeeRService: EmployeeRServiceInterface): EmployeeRControllerInterface {

    @PostMapping("/loginEmployee")
    override fun loginEmployee(@RequestBody body: String): Employee_R? {
        var json = Gson()
        var info: LoginEmployee = json.fromJson(body, LoginEmployee::class.java)
        return employeeRService.loginEmployee(info.document, info.password)
    }

    @PostMapping("/deactivateEmployeeR")
    override fun deactivateEmployeeR(@RequestBody body: String): BooleanResponse {
        var json = Gson()
        var id: String = json.fromJson(body, Document::class.java).id
        return employeeRService.deactivateEmployeeR(id)
    }
}