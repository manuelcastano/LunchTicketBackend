package com.example.lunchticketbackend.repository

import com.example.lunchticketbackend.entity.Restaurant
import com.example.lunchticketbackend.entity.Userr
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import javax.persistence.NamedQuery

@Repository
interface RestaurantRepo : CrudRepository<Restaurant, Long> {

    @Query("SELECT r FROM Restaurant r where r.nit = :nit")
    fun findRestaurantByNit(@Param("nit") nit: String): Restaurant?

    @Modifying
    @Transactional
    @Query("UPDATE Restaurant SET active='N' where nit = :nit")
    fun deactivateRestaurant(@Param("nit") nit: String)

    @Modifying
    @Transactional
    @Query("UPDATE Restaurant SET active='Y' where nit = :nit")
    fun activateRestaurant(@Param("nit") nit: String)
}