package com.example.lunchticketbackend.repository

import com.example.lunchticketbackend.entity.Student
import com.example.lunchticketbackend.entity.Userr
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
interface StudentRepo : CrudRepository<Student, Long> {

    @Query("SELECT e FROM Student e where e.userID.id = :userId")
    fun findStudentByUserId(@Param("userId") userId: Int): Student?

    @Query("SELECT e FROM Student e where e.userID.username = :username")
    fun findStudentByUsername(@Param("username") username: String): Student?

    @Modifying
    @Transactional
    @Query("UPDATE Student SET active='N' where userID.id = :id")
    fun deactivateScholarship(@Param("id") id: Int)

    @Modifying
    @Transactional
    @Query("UPDATE Student set active='Y' where userID.id = :id")
    fun activateScholarship(@Param("id") id: Int)

    @Modifying
    @Transactional
    @Query("UPDATE Student set profilePic = :pictureId where id = :id")
    fun pictureId(@Param("id") id: Int, @Param("pictureId") pictureId: String)

    @Modifying
    @Transactional
    @Query("UPDATE Student set datePic = :datePic where id = :id")
    fun datePic(@Param("id") id: Int, @Param("datePic") datePic: String)
}