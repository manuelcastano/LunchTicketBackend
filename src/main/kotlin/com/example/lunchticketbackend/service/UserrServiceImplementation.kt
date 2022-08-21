package com.example.lunchticketbackend.service

import com.example.lunchticketbackend.entity.*
import com.example.lunchticketbackend.repository.*
import org.springframework.stereotype.Service

@Service
class UserrServiceImplementation(val userRepo: UserrRepo, val studentRepo: StudentRepo, val rolesRepo: RolesRepo, val memberAF: MemberAFRepo, val employeeR: EmployeeRRepo):UserrServiceInterface {

    override fun findAll(): List<Userr> {
        return userRepo.findAll() as List<Userr>
    }

    override fun getAllUsers(): String {
        var lista = ""
        var listaRetornada = userRepo.findAll() as List<Userr>
        for(user in listaRetornada){
            lista += user.pers_name+"\n"
        }
        return lista
    }

    override fun addUser(persName: String, persLastName: String, username: String, role: Int) {
        var userVerification: Userr? = userRepo.findUserByUsername(username)
        if (userVerification == null) {
            var userr: Userr = Userr(0, persName, persLastName, username)
            userRepo.save(userr)
            var user_type: User_type = User_type(0, "")
            if(role == 1){
                var student: Student = Student(null, "", "N", userr)
                studentRepo.save(student)
                user_type = User_type(role, "STUDENT")
            } else if(role == 2){
                var employee_r: Employee_R = Employee_R(null, userr)
                employeeR.save(employee_r)
                user_type = User_type(role, "EMPLOYEE_R")
            } else if(role == 3){
                var member_af: Member_AF = Member_AF(null, "N", userr)
                memberAF.save(member_af)
                user_type = User_type(role, "MEMBER_AF")
            } else if(role == 4){
                var member_af: Member_AF = Member_AF(null, "Y", userr)
                memberAF.save(member_af)
                user_type = User_type(role, "SUPER_ADMIN")
            }
            var role: Roles = Roles(null, userr, user_type)
            rolesRepo.save(role)
        } else{
            var role_id: List<Int> = rolesRepo.findRoleById(userVerification)
            if(!role_id.contains(role)){
                var user_type: User_type = User_type(0, "")
                if(role == 1){
                    var student: Student = Student(null, "", "N", userVerification)
                    studentRepo.save(student)
                    user_type = User_type(role, "STUDENT")
                } else if(role == 2){
                    var employee_r: Employee_R = Employee_R(null, userVerification)
                    employeeR.save(employee_r)
                    user_type = User_type(role, "EMPLOYEE_R")
                } else if(role == 3){
                    var member_af: Member_AF = Member_AF(null, "N", userVerification)
                    memberAF.save(member_af)
                    user_type = User_type(role, "MEMBER_AF")
                } else if(role == 4){
                    var member_af: Member_AF = Member_AF(null, "Y", userVerification)
                    memberAF.save(member_af)
                    user_type = User_type(role, "SUPER_ADMIN")
                }
                var role: Roles = Roles(null, userVerification, user_type)
                rolesRepo.save(role)
            }
        }
    }

    override fun findUserByUsername(document: String): Userr? {
        return userRepo.findUserByUsername(document)
    }
}