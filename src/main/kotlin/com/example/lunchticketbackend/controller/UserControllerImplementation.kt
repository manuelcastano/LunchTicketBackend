package com.example.lunchticketbackend.controller

import com.example.lunchticketbackend.entity.Userr
import com.example.lunchticketbackend.service.UserrServiceInterface
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.*


@RestController
class UserControllerImplementation(val userService: UserrServiceInterface): UserControllerInterface {

    @PostMapping("/addUser")
    override fun addUser(@RequestParam("persName") persName: String, @RequestParam("lastName") lastName: String, @RequestParam("username") username: String, @RequestParam("role") role: Int) {
        return userService.addUser(persName, lastName, username, role)
    }

    @GetMapping("/getUserByUsername")
    override fun findUserByUsername(@RequestParam("username") username: String): Userr? {
        return userService.findUserByUsername(username)
    }
}