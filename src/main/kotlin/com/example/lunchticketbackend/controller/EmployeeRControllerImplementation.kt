package com.example.lunchticketbackend.controller

import com.example.lunchticketbackend.entity.Employee_R
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
}