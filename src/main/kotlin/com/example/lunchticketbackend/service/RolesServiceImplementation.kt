package com.example.lunchticketbackend.service

import com.example.lunchticketbackend.entity.*
import com.example.lunchticketbackend.model.BooleanResponse
import com.example.lunchticketbackend.repository.*
import org.springframework.stereotype.Service

@Service
class RolesServiceImplementation(val rolesRepo: RolesRepo, val userRepo: UserrRepo, val userType: UserTypeRepo, val studentRepo: StudentRepo, val memberAFRepo: MemberAFRepo, val employeeRRepo: EmployeeRRepo):RolesServiceInterface {
    override fun findAll(): List<Roles> {
        return rolesRepo.findAll() as List<Roles>
    }

    override fun addRole(document: String, userTypeId: Int): BooleanResponse {
        var userVerification: Userr? = userRepo.findUserByUsername(document)
        if (userVerification == null) {
            return BooleanResponse(false)
        } else{
            var userTypeVerification: User_type? = userType.findUserTypeById(userTypeId)
            if(userTypeVerification != null){
                var role = Roles(0, userVerification, userTypeVerification)
                var roles: List<User_type> = rolesRepo.findRolesByUserId(userVerification.id)
                if(roles.contains(userTypeVerification)){
                    return BooleanResponse(false)
                }
                if(userTypeVerification.role.equals("STUDENT")){
                    var student = Student(0, "", "Y", userVerification)
                    studentRepo.save(student)
                } else if(userTypeVerification.role.equals("EMPLOYEE_R")){
                    var employeeR = Employee_R(0, userVerification)
                    employeeRRepo.save(employeeR)
                } else if(userTypeVerification.role.equals("MEMBER_AF")){
                    var memberAf = Member_AF(0, "N", userVerification)
                    memberAFRepo.save(memberAf)
                }
                rolesRepo.save(role)
                return BooleanResponse(true)
            } else{
                return BooleanResponse(false)
            }

        }
    }
}