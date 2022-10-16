package com.example.lunchticketbackend.service

import com.example.lunchticketbackend.entity.Member_AF
import com.example.lunchticketbackend.model.BooleanResponse

interface MemberAfServiceInterface {

    fun findAll(): List<Member_AF>
    fun deleteMemberAf(document: String): BooleanResponse
}