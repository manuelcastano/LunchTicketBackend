package com.example.lunchticketbackend.service

import com.example.lunchticketbackend.entity.Employee_R
import com.example.lunchticketbackend.model.BooleanResponse

interface EmployeeRServiceInterface {

    fun loginEmployee(document: String, password: String): Employee_R?
    fun deactivateEmployeeR(id: String): BooleanResponse
    fun activateEmployeeR(id: String): BooleanResponse
    fun getEmployee(id: String): Employee_R?
}