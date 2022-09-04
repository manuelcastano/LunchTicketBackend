package com.example.lunchticketbackend.repository

import com.example.lunchticketbackend.entity.Employee_R
import com.example.lunchticketbackend.entity.User_type
import com.example.lunchticketbackend.entity.Userr
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface EmployeeRRepo : CrudRepository<Employee_R, Long> {

    @Query("DELETE FROM Employee_R where restaurantID.id = :restaurantID")
    fun deleteEmployeeRByRestaurantId(@Param("restaurantID") restaurantID: Int)

    @Query("SELECT e FROM Employee_R e where e.restaurantID.id = :id")
    fun findEmployeeByRestaurantId(@Param("id") id: Int): List<Employee_R>?

    @Query("DELETE FROM Employee_R where id = :id")
    fun deleteEmployeeRById(@Param("id") id: Int)

    @Query("DELETE FROM Employee_R where userID.id = :id")
    fun deleteEmployeeRByUserId(@Param("id") id: Int)
}