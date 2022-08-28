package com.example.lunchticketbackend.service

import com.example.lunchticketbackend.entity.Roles
import com.example.lunchticketbackend.entity.User_type
import com.example.lunchticketbackend.entity.Userr
import com.example.lunchticketbackend.model.BooleanResponse

interface UserrServiceInterface {
    fun findAll():List<Userr>
    fun getAllUsers(): String
    fun login(persName: String, persLastName: String, username: String): List<User_type>
    fun findUserByUsername(document: String): Userr?
}