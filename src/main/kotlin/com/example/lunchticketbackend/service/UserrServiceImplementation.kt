package com.example.lunchticketbackend.service

import com.example.lunchticketbackend.entity.*
import com.example.lunchticketbackend.model.User
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

    override fun addUser(persName: String, persLastName: String, username: String): Userr {
        print(userRepo.getUserAndRolesByUsername(username))
        var userVerification: Userr? = userRepo.getUserAndRolesByUsername(username)
        if (userVerification == null) {
            var userr = Userr(0, persName, persLastName, username)
            return userRepo.save(userr)
        } else{
            return userVerification
        }
    }

    override fun findUserByUsername(document: String): Userr? {
        return userRepo.findUserByUsername(document)
    }
}