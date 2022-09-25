package com.example.lunchticketbackend.repository

import com.example.lunchticketbackend.entity.Employee_R
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
interface EmployeeRRepo : CrudRepository<Employee_R, Long> {

    @Query("DELETE FROM Employee_R where restaurantID.id = :restaurantID")
    fun deleteEmployeeRByRestaurantId(@Param("restaurantID") restaurantID: Int)

    @Query("SELECT e FROM Employee_R e where e.restaurantID.id = :id")
    fun findEmployeeByRestaurantId(@Param("id") id: Int): List<Employee_R>?

    @Query("SELECT e FROM Employee_R e where e.userID.username = :document")
    fun findEmployee(@Param("document") document: String ): Employee_R?

    @Modifying
    @Transactional
    @Query("DELETE FROM Employee_R where id = :id")
    fun deleteEmployeeRById(@Param("id") id: Int)

    @Modifying
    @Transactional
    @Query("DELETE FROM Employee_R where userID.id = :id")
    fun deleteEmployeeRByUserId(@Param("id") id: Int)

    @Query("SELECT e FROM Employee_R e where e.userID.username = :document and e.password = :password")
    fun loginEmployee(@Param("document") document: String, @Param("password") password: String): Employee_R?

    @Modifying
    @Transactional
    @Query("UPDATE Employee_R SET active='N' where restaurantID.nit = :nit")
    fun deactivateEmployeeByNit(@Param("nit") nit: String)

    @Modifying
    @Transactional
    @Query("UPDATE Employee_R SET active='N' where userID.username = :document")
    fun deactivateEmployee(@Param("document") document: String)

    @Modifying
    @Transactional
    @Query("UPDATE Employee_R SET active='Y' where userID.username = :document")
    fun activateEmployee(@Param("document") document: String)
}