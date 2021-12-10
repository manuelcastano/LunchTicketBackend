package com.example.lunchticketbackend.repository

import com.example.lunchticketbackend.entity.Person
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepo : CrudRepository<Person, Long> {

    @Query(value="SELECT p FROM Person p WHERE p.persCode =: personCode")
    fun findPersonByCode(personCode: String): Person
}