package com.example.lunchticketbackend.repository

import com.example.lunchticketbackend.entity.Student
import com.example.lunchticketbackend.entity.Userr
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface StudentRepo : CrudRepository<Student, Long> {

    @Query("SELECT e FROM Student e where e.userID.id = :userId")
    fun findStudentByUserId(@Param("userId") userId: Int): Student?
}