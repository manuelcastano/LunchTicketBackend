package com.example.lunchticketbackend.service

import com.example.lunchticketbackend.entity.Person

interface PersonServiceInterface {
    fun findAll():List<Person>
    fun findPersById(personId:Long):Person
    fun findPersByCode(personCode:String):Person?
    fun findPersonByDocument(document: String): Boolean
}