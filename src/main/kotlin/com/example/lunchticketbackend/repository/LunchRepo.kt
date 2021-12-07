package com.example.lunchticketbackend.repository

import com.example.lunchticketbackend.entity.Lunch
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import javax.persistence.NamedQuery

@Repository
interface LunchRepo : CrudRepository<Lunch, Long> {

    fun findLunchByLunchId(lunchId: Long): Lunch
}