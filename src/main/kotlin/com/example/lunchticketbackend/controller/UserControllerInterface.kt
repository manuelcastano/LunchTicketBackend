package com.example.lunchticketbackend.controller

import com.example.lunchticketbackend.entity.Roles
import com.example.lunchticketbackend.entity.User_type
import com.example.lunchticketbackend.entity.Userr
import com.example.lunchticketbackend.model.BooleanResponse

interface UserControllerInterface {
    fun login(body: String): List<User_type>
    fun findUserByUsername(username: String): Userr?
}