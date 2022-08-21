package com.example.lunchticketbackend.repository

import com.example.lunchticketbackend.entity.Employee_R
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface EmployeeRRepo : CrudRepository<Employee_R, Long> {

}