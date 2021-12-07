package com.example.lunchticketbackend.service

import com.example.lunchticketbackend.entity.Student

interface StudentServiceInterface {
    fun findAll():List<Student>
    fun findStudById(studId:Long):Student
    fun findStudByCode(studentCode:String):Student
}