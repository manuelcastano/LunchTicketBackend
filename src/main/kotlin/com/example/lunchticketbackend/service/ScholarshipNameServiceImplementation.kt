package com.example.lunchticketbackend.service

import com.example.lunchticketbackend.entity.Scholarship_name
import com.example.lunchticketbackend.model.BooleanResponse
import com.example.lunchticketbackend.repository.ScholarshipNameRepo
import org.springframework.stereotype.Service

@Service
class ScholarshipNameServiceImplementation(val scholarshipNameRepo: ScholarshipNameRepo): ScholarshipNameServiceInterface {

    override fun getAllScholarships(): List<Scholarship_name> {
        return scholarshipNameRepo.findAll() as List<Scholarship_name>
    }

    override fun addNewScholarship(name: String): BooleanResponse {
        var newScholarship = Scholarship_name(0, name)
        scholarshipNameRepo.save(newScholarship)
        return BooleanResponse(true, "Beca agregada con exito")
    }
}