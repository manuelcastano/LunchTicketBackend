package com.example.lunchticketbackend.repository

import com.example.lunchticketbackend.entity.Rolee
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface RoleeRepo : CrudRepository<Rolee, Long> {

    fun findRoleByRoleId(roleId: Long): Rolee
}