package com.example.lunchticketbackend.controller

import com.example.lunchticketbackend.entity.Roles
import com.example.lunchticketbackend.entity.User_type
import com.example.lunchticketbackend.entity.Userr
import com.example.lunchticketbackend.model.AddRole
import com.example.lunchticketbackend.model.BooleanResponse
import com.example.lunchticketbackend.model.Document
import com.example.lunchticketbackend.model.User
import com.example.lunchticketbackend.service.RolesServiceInterface
import com.example.lunchticketbackend.service.UserrServiceInterface
import com.google.gson.Gson
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@CrossOrigin
class UserControllerImplementation(val userService: UserrServiceInterface, val rolesService: RolesServiceInterface): UserControllerInterface {

    @PostMapping("/login")
    override fun login(@RequestBody body: String): List<User_type> {
        var json = Gson()
        var user: User = json.fromJson(body, User::class.java)
        return userService.login(user.persName, user.persLastname, user.persIddocument)
    }

    @PostMapping("/getUserByUsername")
    override fun findUserByUsername(@RequestBody body: String): Userr? {
        var json = Gson()
        var document: String = json.fromJson(body, Document::class.java).username
        return userService.findUserByUsername(document)
    }
}