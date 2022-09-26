package com.example.lunchticketbackend.controller

import com.example.lunchticketbackend.entity.Member_AF

interface MemberAfControllerInterface {

    fun getMembersAf(): List<Member_AF>
}