package com.example.lunchticketbackend.service

import com.example.lunchticketbackend.entity.Person
import com.example.lunchticketbackend.entity.Userr
import com.example.lunchticketbackend.repository.PersonRepo
import com.example.lunchticketbackend.repository.UserrRepo
import org.springframework.stereotype.Service

@Service
class UserrServiceImplementation(val userRepo: UserrRepo, val personRepo: PersonRepo):UserrServiceInterface {
    override fun findAll(): List<Userr> {
        return userRepo.findAll() as List<Userr>
    }

    fun findAllByUsername(username: String): List<Userr> {
        return userRepo.findAllByUserName(username)
    }

    override fun getAllUsers(): String {
        var lista = ""
        var listaRetornada = userRepo.findAll() as List<Userr>
        for(user in listaRetornada){
            lista += user.userName+"\n"
        }
        return lista
    }

    override fun addUser(username: String, document: String) {
        var person: Person = Person(null, username, document, "active", "")
        var userr: Userr = Userr(null, username, document)
        personRepo.save(person)
        userRepo.save(userr)
    }
}