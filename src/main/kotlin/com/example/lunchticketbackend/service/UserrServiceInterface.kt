package com.example.lunchticketbackend.service

import com.example.lunchticketbackend.entity.Userr

interface UserrServiceInterface {
    fun findAll():List<Userr>
}