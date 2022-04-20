package com.example.lunchticketbackend.service

import com.example.lunchticketbackend.entity.Userr

interface UserrServiceInterface {
    fun findAll():List<Userr>
    abstract fun getAllUsers(): String
    fun addUser(username: String, document: String)
}