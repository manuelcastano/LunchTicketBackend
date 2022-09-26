package com.example.lunchticketbackend.service

import com.example.lunchticketbackend.entity.Member_AF
import com.example.lunchticketbackend.entity.Restaurant
import com.example.lunchticketbackend.repository.MemberAFRepo
import org.springframework.stereotype.Service

@Service
class MemberAfServiceImplementation(val memberAFRepo: MemberAFRepo): MemberAfServiceInterface {

    override fun findAll(): List<Member_AF> {
        return memberAFRepo.findAll() as List<Member_AF>
    }
}