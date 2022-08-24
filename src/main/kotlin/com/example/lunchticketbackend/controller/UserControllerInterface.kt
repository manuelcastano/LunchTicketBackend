package com.example.lunchticketbackend.controller

import com.example.lunchticketbackend.entity.Roles
import com.example.lunchticketbackend.entity.Userr

interface UserControllerInterface {
    fun login(body: String): List<Roles>
    fun findUserByUsername(username: String): Userr?
}