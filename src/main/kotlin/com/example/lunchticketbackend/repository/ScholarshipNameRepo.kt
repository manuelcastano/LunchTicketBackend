package com.example.lunchticketbackend.repository

import com.example.lunchticketbackend.entity.Scholarship_name
import com.example.lunchticketbackend.entity.User_type
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
interface ScholarshipNameRepo : CrudRepository<Scholarship_name, Long> {

    @Query("SELECT s FROM Scholarship_name s where s.name = :name")
    fun findScholarshipNameByName(@Param("name") name: String): Scholarship_name?

    @Modifying
    @Transactional
    @Query("DELETE FROM Scholarship_name where id = :id")
    fun deleteScholarship(@Param("id") id: Int)
}