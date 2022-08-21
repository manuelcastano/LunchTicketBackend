package com.example.lunchticketbackend.repository

import com.example.lunchticketbackend.entity.Restaurant
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import javax.persistence.NamedQuery

@Repository
interface RestaurantRepo : CrudRepository<Restaurant, Long> {

}