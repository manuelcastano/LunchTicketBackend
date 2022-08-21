package com.example.lunchticketbackend.repository

import com.example.lunchticketbackend.entity.Member_AF
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MemberAFRepo : CrudRepository<Member_AF, Long> {

}