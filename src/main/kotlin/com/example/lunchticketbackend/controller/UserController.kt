package com.example.lunchticketbackend.controller

import com.example.lunchticketbackend.service.UserrServiceImplementation
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException


@RestController
class UserController(val userService: UserrServiceImplementation) {

    @Value("\${jwt.secret}")
    private val secret: String? = null
    //@Autowired
    //private lateinit var userService: UserrServiceImplementation

    @PostMapping("/login")
    fun login(
        @RequestParam("user") username: String,
        @RequestParam("password") pwd: String
    ): String {
        //throw ResponseStatusException(HttpStatus.UNAUTHORIZED, "Cause description here")
        if (userService.validateUser(username, pwd)) {
            return getJWTToken(username)
        } else {
            throw ResponseStatusException(HttpStatus.UNAUTHORIZED, "Cause description here")
        }
    }

    private fun getJWTToken(username: String): String {
        return Jwts.builder()
            .setSubject(username)
            .signWith(SignatureAlgorithm.HS512, secret)
            .compact()
    }

    private fun validateJWTToken(token: String) {
        Jwts.parser().setSigningKey(secret).parseClaimsJws(token).body
    }
}