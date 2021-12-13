package com.example.lunchticketbackend.repository

import com.example.lunchticketbackend.entity.Userr
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface UserrRepo : CrudRepository<Userr, Long> {
    //@Query("SELECT u FROM Userr u WHERE u.userName =: username")
    //fun findByUsername(username: String): Userr?

    fun findAllByUserName(userName: String): List<Userr>
}