package com.example.lunchticketbackend.service

import com.example.lunchticketbackend.entity.*
import com.example.lunchticketbackend.model.BooleanResponse
import com.example.lunchticketbackend.model.EditScholarship
import com.example.lunchticketbackend.repository.ScholarshipNameRepo
import com.example.lunchticketbackend.repository.ScholarshipRegistryRepo
import com.example.lunchticketbackend.repository.StudentRepo
import com.example.lunchticketbackend.repository.UserrRepo
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

@Service
class StudentServiceImplementation(val scholarshipNameRepo: ScholarshipNameRepo, val scholarshipRegistryRepo: ScholarshipRegistryRepo, val userRepo: UserrRepo, val studentRepo: StudentRepo, val userService: UserrServiceInterface, val roleService: RolesServiceInterface): StudentServiceInterface{

    override fun addScholarship(document: String, scholarshipName: String): BooleanResponse {
        //Verificamos que la beca exista
        var scholarshipNameVerification: Scholarship_name? = scholarshipNameRepo.findScholarshipNameByName(scholarshipName)
        if (scholarshipNameVerification == null) {
            return BooleanResponse(false, "La beca no existe")
        } else{
            //obtenemos el id del usuario
            var userVerification: Userr? = userRepo.findUserByUsername(document)
            if(userVerification == null){
                return BooleanResponse(false, "El usuario no existe")
            } else{
                //Obtenemos el estudiante
                var studentVerification: Student? = studentRepo.findStudentByUserId(userVerification.id)
                if(studentVerification == null){
                    return BooleanResponse(false, "El estudiante no existe")
                } else{
                    //Agregamos la beca a la bd
                    val dateTime = LocalDateTime.now()
                        .format(DateTimeFormatter.ofPattern("dd/MMM/yyyy"))
                    var scholarshipRegistry = Scholarship_registry(0, dateTime, "", "Y", scholarshipNameVerification, studentVerification)
                    scholarshipRegistryRepo.save(scholarshipRegistry)
                    //Activamos al estudiante
                    studentRepo.activateScholarship(userVerification.id)
                    return BooleanResponse(true, "Beca añadida correctamente")
                }
            }
        }
    }

    override fun deactivateScholarship(username: String): BooleanResponse {
        var studentVerification: Student? = studentRepo.findStudentByUsername(username)
        if(studentVerification == null){
            return BooleanResponse(false, "El estudiante no existe")
        } else{
            //desactivamos la beca
            studentRepo.deactivateScholarship(studentVerification.userID!!.id)
            //Cogemos las becas activas del estudiante y las desactivamos
            var activeScholarships : List<Scholarship_registry> =  scholarshipRegistryRepo.getActiveScholarshipsByUsername(username)
            val dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MMM/yyyy"))
            for(scholarship in activeScholarships){
                scholarshipRegistryRepo.deactivateScholarship(scholarship.id!!, dateTime)
            }
            return BooleanResponse(true, "Beca desactivada exitosamente")
        }
    }

    override fun editScholarship(info: EditScholarship): BooleanResponse {
        var studentVerification: Student? = studentRepo.findStudentByUsername(info.document)
        if(studentVerification == null){
            return BooleanResponse(false, "El estudiante no existe")
        } else{
            //desactivamos la beca actual
            deactivateScholarship(info.document)
            studentRepo.activateScholarship(studentVerification.userID!!.id)
            //Añadimos la nueva beca
            return addScholarship(info.document, info.scholarshipName)
        }
    }

    override fun findAll(): List<Student> {
        return studentRepo.findAll() as List<Student>
    }

    override fun addStudent(student: com.example.lunchticketbackend.model.Student): BooleanResponse {
        userService.login(student.persName, student.persLastName, student.persIddocument)
        var responseAddRole : BooleanResponse = roleService.addRole(student.persIddocument, 1)
        if(!responseAddRole.response){
            return responseAddRole
        } else{
            return addScholarship(student.persIddocument, student.scholarshipName)
        }
    }

    override fun findStudentByUsername(document: String): Student? {
        return studentRepo.findStudentByUsername(document)
    }
}