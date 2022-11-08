package com.example.lunchticketbackend.service

import HTTPSWebUtil
import com.example.lunchticketbackend.entity.Lunch
import com.example.lunchticketbackend.entity.Restaurant
import com.example.lunchticketbackend.entity.Student
import com.example.lunchticketbackend.model.BooleanResponse
import com.example.lunchticketbackend.model.FCM
import com.example.lunchticketbackend.repository.LunchRepo
import com.example.lunchticketbackend.repository.RestaurantRepo
import com.example.lunchticketbackend.repository.StudentRepo
import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.ByteArrayResource
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
class LunchServiceImplementation(val lunchRepo: LunchRepo, val restaurantRepo: RestaurantRepo, val studentRepo: StudentRepo):LunchServiceInterface {

    @Value("\${lunchticket.waittimeseconds}")
    private val waitTimeSeconds: Long = 1

    override fun findAll(): List<Lunch> {
        return lunchRepo.findAll() as List<Lunch>
    }

    override fun findLunchById(lunchId: Long): Lunch {
        return lunchRepo.findById(lunchId).get()
    }

    override fun create(persCode : String, restNIT: String, timestamp: Long) {
        /*
        val correctTimestamp = timestamp == System.currentTimeMillis() / (1000 * waitTimeSeconds)

        val pers = personRepo.findPersonByDocument(persCode) ?: throw Exception("The user doesn't exist in the database")
        val res = restaurantRepo.findAllByRestNIT(restNIT) ?: throw Exception("The restaurant doesn't exist")
        val lunch = Lunch()
        lunch.lunchPerson = pers
        lunch.lunchRestaurant = res
        val lowerLimit = Calendar.getInstance(TimeZone.getTimeZone("GMT-5"))
        lowerLimit.set(Calendar.HOUR_OF_DAY,0)
        lowerLimit.set(Calendar.MINUTE, 0)
        lowerLimit.set(Calendar.SECOND, 0)
        val upperLimit = Calendar.getInstance(TimeZone.getTimeZone("GMT-5"))
        upperLimit.set(Calendar.HOUR_OF_DAY,24)
        upperLimit.set(Calendar.MINUTE, 0)
        upperLimit.set(Calendar.SECOND, 0)
        lunch.lunchDate = Date()
        val lunches = pers.personLunches
        var alreadyHadLunch = lunches?.any { it.lunchDate.after(lowerLimit.time) && it.lunchDate.before(upperLimit.time) }
        alreadyHadLunch = false
        val inTime = lunch.lunchDate.after(lowerLimit.time) && lunch.lunchDate.before(upperLimit.time)



        if (alreadyHadLunch!! || !inTime || !correctTimestamp) {
            throw Exception()
        }

         */
    }

    override fun saveLunch(persCode: String, restNIT: String, accepted: String): BooleanResponse {
        var studentVerification: Student? = studentRepo.findStudentByUsername(persCode)
        if(studentVerification == null){
            return BooleanResponse(false, "El estudiante no existe")
        } else{
            var restaurantVerification: Restaurant? = restaurantRepo.findRestaurantByNit(restNIT)
            if (restaurantVerification == null) {
                return BooleanResponse(false, "El restaurante no existe")
            } else{
                var lunch = Lunch(0, Date().time, accepted, studentVerification, restaurantVerification)
                var lunchSaved = lunchRepo.save(lunch)
                var http = HTTPSWebUtil()
                var fcm = FCM("/topics/${studentVerification.userID?.username}", lunchSaved)
                http.POSTtoFCM(Gson().toJson(fcm))
                return BooleanResponse(true, "Almuerzo guardado con exito")
            }
        }
    }

    override fun inTime(): Boolean {
        val correctTime = Date()
        val lowerLimit = Calendar.getInstance(TimeZone.getTimeZone("GMT-5"))
        lowerLimit.set(Calendar.HOUR_OF_DAY,0)
        lowerLimit.set(Calendar.MINUTE, 0)
        lowerLimit.set(Calendar.SECOND, 0)
        val upperLimit = Calendar.getInstance(TimeZone.getTimeZone("GMT-5"))
        upperLimit.set(Calendar.HOUR_OF_DAY,24)
        upperLimit.set(Calendar.MINUTE, 0)
        upperLimit.set(Calendar.SECOND, 0)
        return correctTime.after(lowerLimit.time) && correctTime.before(upperLimit.time)
    }

    override fun hasAlreadyLunch(document: String): BooleanResponse {
        var studentVerification: Student? = studentRepo.findStudentByUsername(document)
        if(studentVerification == null){
            return BooleanResponse(false, "El estudiante no existe")
        } else{
            var lunchsAccepted = lunchRepo.lunchsAcceptedByDocument(studentVerification.id!!)
            var already = false
            val expCal = Calendar.getInstance()
            expCal.add(Calendar.HOUR, -6)
            for(lunch: Lunch in lunchsAccepted){
                if(Date(lunch.dateLunch).after(expCal.time)){
                    already = true
                    break
                }
            }
            if(already){
                return BooleanResponse(true, "Ya se reclamó el almuerzo del día de hoy")
            }
            return BooleanResponse(false, "El estudiante aún no ha almorzado")
        }
    }

    override fun lastLunchInTheDay(document: String): Lunch? {
        var studentVerification: Student? = studentRepo.findStudentByUsername(document)
        if(studentVerification == null){
            return null
        } else{
            var lunchs = lunchRepo.lunchsByDocument(studentVerification.id!!)
            var lastLunch: Lunch? = null
            var lastTime: Long = 0
            for(lunch: Lunch in lunchs){
                if(lunch.dateLunch > lastTime){
                    lastLunch = lunch
                    lastTime = lunch.dateLunch
                }
            }
            val expCal = Calendar.getInstance()
            expCal.add(Calendar.HOUR, -6)
            if(Date(lastTime).before(expCal.time)){
                return null
            } else{
                return lastLunch
            }
        }
    }
}
