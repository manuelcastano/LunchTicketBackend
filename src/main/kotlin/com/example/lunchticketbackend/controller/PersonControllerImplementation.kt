package com.example.lunchticketbackend.controller

import com.example.lunchticketbackend.entity.Person
import com.example.lunchticketbackend.service.PersonServiceInterface
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class PersonControllerImplementation(val persService:PersonServiceInterface):PersonControllerInterface{

    @GetMapping("/persons")
    override fun getPersons(): List<Person> {
        return persService.findAll()
    }

    @GetMapping("/findPersonByDocument")
    fun findPersonByDocument(@RequestParam("document") document: String):Boolean{
        return persService.findPersonByDocument(document)
    }
}