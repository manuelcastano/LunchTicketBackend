package com.example.lunchticketbackend.service

import com.example.lunchticketbackend.entity.Employee_R

interface EmployeeRServiceInterface {

    fun loginEmployee(document: String, password: String): Employee_R?
}