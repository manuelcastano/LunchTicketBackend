package com.example.lunchticketbackend.repository

import com.example.lunchticketbackend.entity.Userr
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional


@Repository
interface UserrRepo : CrudRepository<Userr, Long> {

    @Query("SELECT u FROM Userr u where u.username = :username")
    fun findUserByUsername(@Param("username") username: String): Userr?

    @Modifying
    @Transactional
    @Query("DELETE FROM Userr where id = :id")
    fun deleteUserById(@Param("id") id: Int)
}