package com.example.lunchticketbackend.repository

import com.example.lunchticketbackend.entity.Restaurant
import com.example.lunchticketbackend.entity.Userr
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import javax.persistence.NamedQuery

@Repository
interface RestaurantRepo : CrudRepository<Restaurant, Long> {

    @Query("SELECT r FROM Restaurant r where r.nit = :nit")
    fun findRestaurantByNit(@Param("nit") nit: String): Restaurant?
}