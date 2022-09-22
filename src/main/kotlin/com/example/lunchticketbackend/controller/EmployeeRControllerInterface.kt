package com.example.lunchticketbackend.controller

import com.example.lunchticketbackend.entity.Employee_R
import com.example.lunchticketbackend.model.BooleanResponse

interface EmployeeRControllerInterface {

    fun loginEmployee(body: String): Employee_R?
    fun deactivateEmployeeR(body: String): BooleanResponse
}