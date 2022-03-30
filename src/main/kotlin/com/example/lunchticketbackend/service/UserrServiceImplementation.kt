package com.example.lunchticketbackend.service

import com.example.lunchticketbackend.entity.Userr
import com.example.lunchticketbackend.repository.UserrRepo
import org.springframework.stereotype.Service

@Service
class UserrServiceImplementation(val userRepo: UserrRepo):UserrServiceInterface {
    override fun findAll(): List<Userr> {
        return userRepo.findAll() as List<Userr>
    }

    fun findAllByUsername(username: String): List<Userr> {
        return userRepo.findAllByUserName(username)
    }

    override fun validateUser(username: String, password: String): Boolean {
        val user = userRepo.findAllByUserName(username)
        if (user.isNotEmpty()) {
            return user[0].userPsswd == password
        }
        return false
    }

    override fun getAllUsers(): String {
        var lista = ""
        var listaRetornada = userRepo.findAll() as List<Userr>
        for(user in listaRetornada){
            lista += user.userName+"\n"
        }
        return lista
    }
}