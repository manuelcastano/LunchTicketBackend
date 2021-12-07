package com.example.lunchticketbackend.service

import com.example.lunchticketbackend.entity.Student
import com.example.lunchticketbackend.repository.StudentRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StudentServiceImplementation(val studRepo: StudentRepo) : StudentServiceInterface {

    override fun findAll(): List<Student> {
        return studRepo.findAll() as List<Student>
    }

    override fun findStudById(studId:Long): Student {
        return studRepo.findById(studId).get()
    }

    override fun findStudByCode(studentCode:String): Student {
        return studRepo.findStudByCode(studentCode)
    }
}