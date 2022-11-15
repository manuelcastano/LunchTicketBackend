package com.example.lunchticketbackend.service

import com.example.lunchticketbackend.entity.Lunch
import com.example.lunchticketbackend.entity.Member_AF
import com.example.lunchticketbackend.model.BooleanResponse

interface MemberAfServiceInterface {

    fun findAll(): List<Member_AF>
    fun deleteMemberAf(document: String): BooleanResponse
    fun getReportArray(startDate: Long, finalDate: Long): List<Lunch>
    fun getReportExcel(startDate: Long, finalDate: Long): ByteArray
}