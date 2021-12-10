package com.example.lunchticketbackend.repository

import com.example.lunchticketbackend.entity.Userr
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface UserrRepo : CrudRepository<Userr, Long> {

    fun findUserByUserId(userId: Long): Userr
}