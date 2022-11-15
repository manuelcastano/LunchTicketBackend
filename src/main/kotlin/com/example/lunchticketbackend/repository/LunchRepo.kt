package com.example.lunchticketbackend.repository

import com.example.lunchticketbackend.entity.Employee_R
import com.example.lunchticketbackend.entity.Lunch
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import javax.persistence.NamedQuery

@Repository
interface LunchRepo : CrudRepository<Lunch, Long> {

    @Query("SELECT l FROM Lunch l where l.studentID.id = :id and l.accepted='Y'")
    fun lunchsAcceptedByDocument(@Param("id") id: Int): List<Lunch>

    @Query("SELECT l FROM Lunch l where l.studentID.id = :id")
    fun lunchsByDocument(@Param("id") id: Int): List<Lunch>

    @Query("SELECT l FROM Lunch l where l.dateLunch > :startDate and l.dateLunch < :finalDate")
    fun lunchsByDates(@Param("startDate") startDate: Long, @Param("finalDate") finalDate: Long): List<Lunch>
}