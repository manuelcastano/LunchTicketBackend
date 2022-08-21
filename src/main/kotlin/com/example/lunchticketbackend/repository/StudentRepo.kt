package com.example.lunchticketbackend.repository

import com.example.lunchticketbackend.entity.Student
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRepo : CrudRepository<Student, Long> {

}