package com.example.lunchticketbackend.repository

import com.example.lunchticketbackend.entity.Scholarship_name
import com.example.lunchticketbackend.entity.User_type
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ScholarshipNameRepo : CrudRepository<Scholarship_name, Long> {

    @Query("SELECT s FROM Scholarship_name s where s.name = :name")
    fun findScholarshipNameByName(@Param("name") name: String): Scholarship_name?
}