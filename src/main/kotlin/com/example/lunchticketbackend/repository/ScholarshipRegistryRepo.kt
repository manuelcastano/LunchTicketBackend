package com.example.lunchticketbackend.repository

import com.example.lunchticketbackend.entity.Scholarship_name
import com.example.lunchticketbackend.entity.Scholarship_registry
import com.example.lunchticketbackend.entity.User_type
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ScholarshipRegistryRepo : CrudRepository<Scholarship_registry, Long> {
}