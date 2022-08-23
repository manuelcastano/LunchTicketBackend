package com.example.lunchticketbackend.controller

import com.example.lunchticketbackend.entity.Userr
import com.example.lunchticketbackend.model.User
import com.example.lunchticketbackend.service.UserrServiceInterface
import com.google.gson.Gson
import org.springframework.web.bind.annotation.*


@RestController
@CrossOrigin
class UserControllerImplementation(val userService: UserrServiceInterface): UserControllerInterface {

    /*
    @PostMapping("/addUser")
    override fun addUser(@RequestParam("persName") persName: String, @RequestParam("lastName") lastName: String, @RequestParam("username") username: String, @RequestParam("role") role: Int) {
        return userService.addUser(persName, lastName, username, role)
    }*/
    @PostMapping("/addUser")
    @CrossOrigin(origins = arrayOf("*"), allowedHeaders = arrayOf("*"))
    override fun login(@RequestBody body: String):Userr {
        var json = Gson()
        var user: User = json.fromJson(body, User::class.java)
        print("This is the user: "+ user)
        return userService.addUser(user.persName, user.lastName, user.username)
    }

    @GetMapping("/getUserByUsername")
    override fun findUserByUsername(@RequestParam("username") username: String): Userr? {
        return userService.findUserByUsername(username)
    }
}