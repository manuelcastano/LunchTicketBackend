package com.example.lunchticketbackend.service

import com.example.lunchticketbackend.entity.Lunch
import com.example.lunchticketbackend.repository.LunchRepo
import com.example.lunchticketbackend.repository.RestaurantRepo
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.util.*

@Service
class LunchServiceImplementation(val lunchRepo: LunchRepo, val restaurantRepo: RestaurantRepo):LunchServiceInterface {

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

    override fun saveLunch(persCode : String, restNIT: String) {
        /*
        val pers = personRepo.findPersonByDocument(persCode) ?: throw Exception("The user doesn't exist in the database")
        val res = restaurantRepo.findAllByRestNIT(restNIT) ?: throw Exception("The restaurant doesn't exist")
        val lunch = Lunch()
        lunch.lunchPerson = pers
        lunch.lunchRestaurant = res
        lunch.lunchDate = Date()
        val lunches = pers.personLunches
        lunchRepo.save(lunch)

         */
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
}
