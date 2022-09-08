package com.example.lunchticketbackend.service

import com.example.lunchticketbackend.entity.Employee_R
import com.example.lunchticketbackend.entity.Restaurant
import com.example.lunchticketbackend.entity.Userr
import com.example.lunchticketbackend.model.AddEmployeeR
import com.example.lunchticketbackend.model.BooleanResponse
import com.example.lunchticketbackend.repository.EmployeeRRepo
import com.example.lunchticketbackend.repository.RestaurantRepo
import com.example.lunchticketbackend.repository.UserrRepo
import org.springframework.stereotype.Service

@Service
class RestaurantServiceImplementation(val restRepo: RestaurantRepo, val employeeRRepo: EmployeeRRepo, val userRepo: UserrRepo):RestaurantServiceInterface{

    override fun findAll(): List<Restaurant> {
        return restRepo.findAll() as List<Restaurant>
    }

    override fun findRestById(restaurantId: Long): Restaurant {
        return restRepo.findById(restaurantId).get()
    }

    override fun addRestaurant(restaurant: com.example.lunchticketbackend.model.Restaurant): BooleanResponse {
        var restaurantVerification: Restaurant? = restRepo.findRestaurantByNit(restaurant.nit)
        if (restaurantVerification == null) {
            var rest = Restaurant(0, restaurant.name, restaurant.nit, restaurant.pictureUrl)
            restRepo.save(rest)
        }
        return BooleanResponse(true, "Agregado exitosamente")
    }

    override fun findRestaurantByNit(nit: String): Restaurant? {
        return restRepo.findRestaurantByNit(nit)
    }

    override fun deleteRestaurant(nit: String): BooleanResponse {
        var restaurantVerification: Restaurant? = restRepo.findRestaurantByNit(nit)
        if (restaurantVerification == null) {
            return BooleanResponse(false, "El restaurante no existe")
        } else {
            var employees : List<Employee_R>? = employeeRRepo.findEmployeeByRestaurantId(restaurantVerification.id!!)
            if (employees != null) {
                for(employee in employees){
                    employeeRRepo.deleteEmployeeRById(employee.id!!)
                    userRepo.deleteUserById(employee.id!!)
                }
            }
            restRepo.delete(restaurantVerification)
            return BooleanResponse(true, "Eliminado exitosamente")
        }
    }

    override fun deleteRestaurantEmployee(document: String): BooleanResponse {
        var userVerification: Userr? = userRepo.findUserByUsername(document)
        if (userVerification == null) {
            return BooleanResponse(false, "El usuario no existe")
        } else {
            employeeRRepo.deleteEmployeeRByUserId(userVerification.id)
            userRepo.deleteUserById(userVerification.id)
            return BooleanResponse(true, "Eliminado exitosamente")
        }
    }

    override fun addRestaurantEmployee(info: AddEmployeeR): BooleanResponse {
        var restaurantVerification: Restaurant? = restRepo.findRestaurantByNit(info.nit)
        if (restaurantVerification == null) {
            return BooleanResponse(false, "El restaurante no existe")
        } else {
            var userVerification: Userr? = userRepo.findUserByUsername(info.document)
            if (userVerification == null) {
                var user = Userr(0, info.name, info.lastName, info.document)
                userVerification = userRepo.save(user)
                var employeeR = Employee_R(0, userVerification, restaurantVerification, info.password)
                employeeRRepo.save(employeeR)
                return BooleanResponse(true, "Agregado exitosamente")
            } else{
                return BooleanResponse(false, "El usuario ya existe")
            }
        }
    }

    override fun getEmployees(id: String): List<Employee_R>? {
        var restaurantVerification: Restaurant? = restRepo.findRestaurantByNit(id)
        if (restaurantVerification == null) {
            return null
        } else {
            return employeeRRepo.findEmployeeByRestaurantId(restaurantVerification.id!!)
        }
    }
}