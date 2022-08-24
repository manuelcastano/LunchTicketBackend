package com.example.lunchticketbackend.repository

import com.example.lunchticketbackend.entity.Userr
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository


@Repository
interface UserrRepo : CrudRepository<Userr, Long> {

    @Query("SELECT u FROM Userr u where u.username = :username")
    fun findUserByUsername(@Param("username") username: String): Userr?

    @Query("SELECT u FROM Userr u inner join Roles r on u.id = r.userID.id where u.username = :username")
    fun getUserAndRolesByUsername(@Param("username") username: String): Userr?
}