package com.example.lunchticketbackend.controller

import com.example.lunchticketbackend.entity.Member_AF
import com.example.lunchticketbackend.model.BooleanResponse

interface MemberAfControllerInterface {

    fun getMembersAf(): List<Member_AF>
    fun deleteMemberAf(body: String): BooleanResponse
}