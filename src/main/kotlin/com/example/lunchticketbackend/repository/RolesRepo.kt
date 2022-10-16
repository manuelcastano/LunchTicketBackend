package com.example.lunchticketbackend.repository

import com.example.lunchticketbackend.entity.Roles
import com.example.lunchticketbackend.entity.User_type
import com.example.lunchticketbackend.entity.Userr
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional


@Repository
interface RolesRepo : CrudRepository<Roles, Long> {

    @Query("SELECT r.userTypeID FROM Roles r where r.userID.id = :userID")
    fun findRolesByUserId(@Param("userID") userID: Int): List<User_type>

    @Query("SELECT r.userTypeID FROM Roles r where r.userID.username = :userDocument")
    fun findRolesByUserDocument(@Param("userDocument") userDocument: String): List<User_type>

    @Modifying
    @Transactional
    @Query("DELETE FROM Roles where userID.id = :id")
    fun deleteRolesById(@Param("id") id: Int)

    @Modifying
    @Transactional
    @Query("DELETE FROM Roles where userID.id = :id and userTypeID.id = :role")
    fun deleteRoleById(@Param("id") id: Int, @Param("role") role: Int)
}