package com.example.lunchticketbackend.controller

import com.example.lunchticketbackend.entity.Userr

interface UserControllerInterface {

    fun addUser(persName: String, lastName: String, username: String, role: Int)
    fun findUserByUsername(username: String): Userr?
}