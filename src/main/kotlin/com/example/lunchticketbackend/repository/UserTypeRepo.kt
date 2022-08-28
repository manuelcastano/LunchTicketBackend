package com.example.lunchticketbackend.repository

import com.example.lunchticketbackend.entity.User_type
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface UserTypeRepo : CrudRepository<User_type, Long> {

    @Query("SELECT u FROM User_type u where u.id = :id")
    fun findUserTypeById(@Param("id") id: Int): User_type?
}