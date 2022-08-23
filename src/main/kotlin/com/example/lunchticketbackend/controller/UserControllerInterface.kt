package com.example.lunchticketbackend.controller

import com.example.lunchticketbackend.entity.Userr

interface UserControllerInterface {

    fun login(body: String): Userr
    fun findUserByUsername(username: String): Userr?
}