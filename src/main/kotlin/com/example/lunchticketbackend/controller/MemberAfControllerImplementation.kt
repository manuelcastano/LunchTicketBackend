package com.example.lunchticketbackend.controller

import com.example.lunchticketbackend.entity.Lunch
import com.example.lunchticketbackend.entity.Member_AF
import com.example.lunchticketbackend.model.BooleanResponse
import com.example.lunchticketbackend.model.Dates
import com.example.lunchticketbackend.model.Document
import com.example.lunchticketbackend.service.MemberAfServiceInterface
import com.google.gson.Gson
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
class MemberAfControllerImplementation(val memberAfService: MemberAfServiceInterface): MemberAfControllerInterface {

    @GetMapping("/membersAf")
    override fun getMembersAf(): List<Member_AF> {
        return memberAfService.findAll()
    }

    @PostMapping("/deleteMemberAf")
    override fun deleteMemberAf(@RequestBody body: String): BooleanResponse {
        var json = Gson()
        var document: String = json.fromJson(body, Document::class.java).id
        return memberAfService.deleteMemberAf(document)
    }

    @PostMapping("/getReportArray")
    override fun getReportArray(@RequestBody body: String): List<Lunch> {
        var json = Gson()
        var dates: Dates = json.fromJson(body, Dates::class.java)
        return memberAfService.getReportArray(dates.startDate, dates.finalDate)
    }
}