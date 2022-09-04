package com.example.lunchticketbackend.controller

import com.example.lunchticketbackend.entity.Userr
import com.example.lunchticketbackend.model.*
import com.example.lunchticketbackend.entity.Restaurant as Restaurante
import com.example.lunchticketbackend.service.RestaurantServiceInterface
import com.google.gson.Gson
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
class RestaurantControllerImplementantion(val restService: RestaurantServiceInterface): RestaurantControllerInterface {

    @GetMapping("/restaurants")
    override fun getRestaurants(): List<Restaurante> {
        return restService.findAll()
    }

    @PostMapping("/addRestaurant")
    override fun addRestaurant(@RequestBody body: String): BooleanResponse {
        var json = Gson()
        var toAdd: Restaurant = json.fromJson(body, Restaurant::class.java)
        return restService.addRestaurant(toAdd)
    }

    @PostMapping("/getRestaurantByNit")
    override fun findRestaurant(@RequestBody body: String): com.example.lunchticketbackend.entity.Restaurant? {
        var json = Gson()
        var nit: String = json.fromJson(body, Nit::class.java).nit
        return restService.findRestaurantByNit(nit)
    }

    @PostMapping("/deleteRestaurant")
    override fun deleteRestaurant(@RequestBody body: String): BooleanResponse {
        var json = Gson()
        var nit: String = json.fromJson(body, Nit::class.java).nit
        return restService.deleteRestaurant(nit)
    }

    @PostMapping("/deleteRestaurantEmployee")
    override fun deleteRestaurantEmployee(@RequestBody body: String): BooleanResponse {
        var json = Gson()
        var document: String = json.fromJson(body, Document::class.java).username
        return restService.deleteRestaurantEmployee(document)
    }

    @PostMapping("/addRestaurantEmployee")
    override fun addRestaurantEmployee(@RequestBody body: String): BooleanResponse {
        var json = Gson()
        var info: AddEmployeeR = json.fromJson(body, AddEmployeeR::class.java)
        return restService.addRestaurantEmployee(info)
    }
}