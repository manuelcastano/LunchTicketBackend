package com.example.lunchticketbackend.controller

import com.example.lunchticketbackend.entity.Person

interface PersonControllerInterface {
    fun getPersons():List<Person>
}