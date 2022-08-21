package com.example.lunchticketbackend.repository

import com.example.lunchticketbackend.entity.Roles
import com.example.lunchticketbackend.entity.Userr
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository


@Repository
interface RolesRepo : CrudRepository<Roles, Long> {

    @Query("SELECT r.userTypeID.id FROM Roles r where r.userID = :userID")
    fun findRoleById(@Param("userID") userID: Userr): List<Int>
}