package com.example.lunchticketbackend.controller

import com.example.lunchticketbackend.entity.Userr
import com.example.lunchticketbackend.model.User
import com.example.lunchticketbackend.service.UserrServiceInterface
import com.google.gson.Gson
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@CrossOrigin
class UserControllerImplementation(val userService: UserrServiceInterface): UserControllerInterface {

    @PostMapping("/addUser")
    override fun login(@RequestBody body: String):ResponseEntity<Userr> {
        val responseHeaders = HttpHeaders()
        responseHeaders.set(
            "Access-Control-Allow-Origin",
            "*"
        )
        var json = Gson()
        var user: User = json.fromJson(body, User::class.java)
        print("This is the user: "+ user)
        return ResponseEntity.ok()
            .headers(responseHeaders)
            .body(userService.addUser(user.persName, user.lastName, user.username))
    }

    @GetMapping("/getUserByUsername")
    override fun findUserByUsername(@RequestParam("username") username: String): Userr? {
        return userService.findUserByUsername(username)
    }
}