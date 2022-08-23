package com.example.lunchticketbackend.controller

import com.example.lunchticketbackend.entity.Userr
import org.springframework.http.ResponseEntity

interface UserControllerInterface {

    fun login(body: String): ResponseEntity<Userr>
    fun findUserByUsername(username: String): Userr?
}