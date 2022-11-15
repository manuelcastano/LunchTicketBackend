package com.example.lunchticketbackend.controller

import com.example.lunchticketbackend.entity.Lunch
import com.example.lunchticketbackend.entity.Member_AF
import com.example.lunchticketbackend.model.BooleanResponse
import com.example.lunchticketbackend.model.Dates

interface MemberAfControllerInterface {

    fun getMembersAf(): List<Member_AF>
    fun deleteMemberAf(body: String): BooleanResponse
    fun getReportArray(body: String): List<Lunch>
}