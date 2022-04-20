package com.example.lunchticketbackend.service

import com.example.lunchticketbackend.entity.Person
import com.example.lunchticketbackend.repository.PersonRepo
import org.springframework.stereotype.Service

@Service
class PersonServiceImplementation(val persRepo: PersonRepo) : PersonServiceInterface {

    override fun findAll(): List<Person> {
        return persRepo.findAll() as List<Person>
    }

    override fun findPersById(personId:Long): Person {
        return persRepo.findById(personId).get()
    }

    override fun findPersByCode(personCode:String): Person? {
        return persRepo.findPersonByDocument(personCode)
    }

    override fun findPersonByDocument(document: String): Boolean {
        var retorno = false
        var person = persRepo.findPersonByDocument(document)
        if(person != null)
            retorno = true
        return retorno
    }
}