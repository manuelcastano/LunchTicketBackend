package com.example.lunchticketbackend.service

import com.example.lunchticketbackend.entity.Employee_R
import com.example.lunchticketbackend.repository.EmployeeRRepo
import org.springframework.stereotype.Service

@Service
class EmployeeRServiceImplementation(val employeeRRepo: EmployeeRRepo): EmployeeRServiceInterface {

    override fun loginEmployee(document: String, password: String): Employee_R? {
        return employeeRRepo.loginEmployee(document, password)
    }
}