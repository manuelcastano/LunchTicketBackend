package com.example.lunchticketbackend.service

import com.example.lunchticketbackend.entity.Member_AF

interface MemberAfServiceInterface {

    fun findAll(): List<Member_AF>
}