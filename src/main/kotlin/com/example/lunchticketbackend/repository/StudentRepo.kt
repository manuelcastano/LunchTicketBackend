package com.example.lunchticketbackend.repository

import com.example.lunchticketbackend.entity.Student
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import javax.persistence.NamedQuery

@Repository
interface StudentRepo : CrudRepository<Student, Long> {

    fun findStudByStudId(studId: Long): Student
    @Query(value="SELECT s FROM Student s WHERE s.studCode =: studentCode")
    fun findStudByCode(studentCode: String): Student
}