package com.example.lunchticketbackend.service

import com.example.lunchticketbackend.entity.Lunch
import com.example.lunchticketbackend.entity.Member_AF
import com.example.lunchticketbackend.entity.Restaurant
import com.example.lunchticketbackend.entity.Student
import com.example.lunchticketbackend.model.BooleanResponse
import com.example.lunchticketbackend.repository.LunchRepo
import com.example.lunchticketbackend.repository.MemberAFRepo
import com.example.lunchticketbackend.repository.RolesRepo
import com.example.lunchticketbackend.repository.UserrRepo
import org.springframework.core.io.ByteArrayResource
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class MemberAfServiceImplementation(val memberAFRepo: MemberAFRepo, val lunchRepo: LunchRepo, val rolesRepo: RolesRepo): MemberAfServiceInterface {

    override fun findAll(): List<Member_AF> {
        return memberAFRepo.findAll() as List<Member_AF>
    }

    override fun deleteMemberAf(document: String): BooleanResponse {
        var memberAfVerification: Member_AF? = memberAFRepo.findMemberAF(document)
        if(memberAfVerification == null){
            return BooleanResponse(false, "La persona no existe en la base de datos")
        } else{
            rolesRepo.deleteRoleById(memberAfVerification.userID!!.id, 3)
            memberAFRepo.deleteMemberAfById(memberAfVerification.id)
            return BooleanResponse(true, "eliminación exitosa")
        }
    }

    override fun getReportArray(startDate: Long, finalDate: Long): List<Lunch> {
        return lunchRepo.lunchsByDates(startDate, finalDate)
    }
}