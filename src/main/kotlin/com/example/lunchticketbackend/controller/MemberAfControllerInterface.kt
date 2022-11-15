package com.example.lunchticketbackend.controller

import com.example.lunchticketbackend.entity.Lunch
import com.example.lunchticketbackend.entity.Member_AF
import com.example.lunchticketbackend.model.BooleanResponse
import com.example.lunchticketbackend.model.Dates
import org.springframework.http.ResponseEntity

interface MemberAfControllerInterface {

    fun getMembersAf(): List<Member_AF>
    fun deleteMemberAf(body: String): BooleanResponse
    fun getReportArray(body: String): List<Lunch>
    fun getReportExcel(body: String): ResponseEntity<ByteArray>
}