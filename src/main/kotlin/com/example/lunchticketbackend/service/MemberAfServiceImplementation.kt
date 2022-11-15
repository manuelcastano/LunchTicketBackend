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
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.springframework.core.io.ByteArrayResource
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.io.ByteArrayOutputStream
import java.text.SimpleDateFormat
import java.util.*

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

    override fun getReportExcel(startDate: Long, finalDate: Long): ByteArray {
        var lunchs = lunchRepo.lunchsByDates(startDate, finalDate)
        val wb = XSSFWorkbook()
        val sheet: Sheet = wb.createSheet("Almuerzos")
        val row = sheet.createRow(0)
        var cell = row.createCell(0)
        cell.setCellValue("Nombre")
        cell = row.createCell(1)
        cell.setCellValue("Apellido")
        cell = row.createCell(2)
        cell.setCellValue("Número de identificación")
        cell = row.createCell(3)
        cell.setCellValue("Cafeteria")
        cell = row.createCell(4)
        cell.setCellValue("Fecha")
        cell = row.createCell(5)
        cell.setCellValue("Estado")
        for (i in 0 until lunchs.size) {
            val row2 = sheet.createRow(i+1)
            var cell2 = row2.createCell(0)
            cell2.setCellValue(lunchs.get(i).studentID!!.userID!!.pers_name)
            cell2 = row2.createCell(1)
            cell2.setCellValue(lunchs.get(i).studentID!!.userID!!.pers_lastname)
            cell2 = row2.createCell(2)
            cell2.setCellValue(lunchs.get(i).studentID!!.userID!!.username)
            cell2 = row2.createCell(3)
            cell2.setCellValue(lunchs.get(i).restaurantID!!.name)
            cell2 = row2.createCell(4)
            val date = Date(lunchs.get(i).dateLunch)
            val format = SimpleDateFormat("yyyy/MM/dd HH:mm")
            cell2.setCellValue(format.format(date))
            cell2 = row2.createCell(5)
            if(lunchs.get(i).accepted.equals("Y")){
                cell2.setCellValue("Aceptado")
            } else{
                cell2.setCellValue("Rechazado")
            }
        }
        val out = ByteArrayOutputStream()
        wb.write(out)

        out.close()
        wb.close()

        return out.toByteArray()
    }
}