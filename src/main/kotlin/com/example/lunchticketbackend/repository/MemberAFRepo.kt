package com.example.lunchticketbackend.repository

import com.example.lunchticketbackend.entity.Employee_R
import com.example.lunchticketbackend.entity.Member_AF
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
interface MemberAFRepo : CrudRepository<Member_AF, Long> {

    @Query("SELECT m FROM Member_AF m where m.userID.username = :document")
    fun findMemberAF(@Param("document") document: String ): Member_AF?

    @Modifying
    @Transactional
    @Query("DELETE FROM Member_AF where id = :id")
    fun deleteMemberAfById(@Param("id") id: Int)
}