package com.example.lunchticketbackend.controller

import com.example.lunchticketbackend.entity.Userr
import com.example.lunchticketbackend.repository.PersonRepo
import com.example.lunchticketbackend.repository.RestaurantRepo
import com.example.lunchticketbackend.service.UserrServiceImplementation
import com.google.gson.Gson
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.*


@RestController
class UserController(val userService: UserrServiceImplementation, val personRepo: PersonRepo, val restaurantRepo: RestaurantRepo) {

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
            userService
            return getJWTToken(username)
        } else {
            throw ResponseStatusException(HttpStatus.UNAUTHORIZED, "Cause description here")
        }
    }

    @GetMapping("/findAllUsers")
    fun findAllUsers():String{
        return userService.getAllUsers()
    }

    @PostMapping("/userProfilePic")
    fun setProfilePic(@RequestBody pic: String, @RequestParam("user") user: String): String {
        val user = userService.findAllByUsername(user)[0]
        if(user.person != null) {
            val person = user.person!!
            person.persProfPic = pic
            personRepo.save(person)
        } else{
            val rest = user.restaurant!!
            rest.restProfPic = pic
            restaurantRepo.save(rest)
        }
        return "ok"
    }

    private fun getJWTToken(username: String): String {
        val user = userService.findAllByUsername(username)[0]
        var code = ""
        var name = ""
        var pic = ""
        var doc = ""

        if(user.person != null) {
            code = user.person!!.persCode
            name = user.person!!.persName
            pic = user.person!!.persProfPic
            doc = user.person!!.persDoc
        } else{
            code = user.restaurant!!.restNIT
            name = user.restaurant!!.restName
            pic = user.restaurant!!.restProfPic
        }

        return Jwts.builder()
            .setSubject(username)
            .claim("code", code)
            .claim("name", name)
            .claim("pic", pic)
            .claim("doc", doc)
            .signWith(SignatureAlgorithm.HS512, secret)
            .compact()
    }

    private fun validateJWTToken(token: String) {
        Jwts.parser().setSigningKey(secret).parseClaimsJws(token).body
    }
}