package com.example.lunchticketbackend.controller

import com.example.lunchticketbackend.entity.Employee_R

interface EmployeeRControllerInterface {

    fun loginEmployee(body: String): Employee_R?
}