package com.example.lunchticketbackend.controller

import com.example.lunchticketbackend.entity.Student

interface StudentControllerInterface {

    fun getStudents():List<Student>
}