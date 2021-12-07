package com.example.lunchticketbackend.repository

import com.example.lunchticketbackend.entity.FinancialOffice
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import javax.persistence.NamedQuery

@Repository
interface FinancialOfficeRepo : CrudRepository<FinancialOffice, Long> {

    fun findFinOffByFinOffId(finOffId: Long): FinancialOffice
}