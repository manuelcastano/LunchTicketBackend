package com.example.lunchticketbackend.controller

import com.example.lunchticketbackend.entity.Employee_R
import com.example.lunchticketbackend.model.AddRole
import com.example.lunchticketbackend.model.BooleanResponse
import com.example.lunchticketbackend.model.Document
import com.example.lunchticketbackend.service.RolesServiceInterface
import com.google.gson.Gson
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
class RolesControllerImplementation(val rolesService: RolesServiceInterface): RolesControllerInterface {

    @PostMapping("/addRole")
    override fun addRole(@RequestBody body: String): BooleanResponse {
        var json = Gson()
        var toAdd: AddRole = json.fromJson(body, AddRole::class.java)
        return rolesService.addRole(toAdd.document, toAdd.userTypeId)
    }
}