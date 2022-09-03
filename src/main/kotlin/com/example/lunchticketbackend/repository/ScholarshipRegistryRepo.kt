package com.example.lunchticketbackend.repository

import com.example.lunchticketbackend.entity.Scholarship_name
import com.example.lunchticketbackend.entity.Scholarship_registry
import com.example.lunchticketbackend.entity.User_type
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ScholarshipRegistryRepo : CrudRepository<Scholarship_registry, Long> {

    @Query("SELECT s FROM Scholarship_registry s where (s.studentID.userID.username = :username) and (s.active = 'Y')")
    fun getActiveScholarshipsByUsername(@Param("username") username: String): List<Scholarship_registry>

    @Query("UPDATE Scholarship_registry set active='N', end_date = :endDate where id = :id")
    fun deactivateScholarship(@Param("id") id: Int, @Param("endDate") endDate: String)
}