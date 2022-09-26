package com.example.lunchticketbackend.controller

import com.example.lunchticketbackend.entity.Member_AF
import com.example.lunchticketbackend.service.MemberAfServiceInterface
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
class MemberAfControllerImplementation(val memberAfService: MemberAfServiceInterface): MemberAfControllerInterface {

    @GetMapping("/membersAf")
    override fun getMembersAf(): List<Member_AF> {
        return memberAfService.findAll()
    }
}