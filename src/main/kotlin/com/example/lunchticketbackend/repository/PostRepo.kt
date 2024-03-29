package com.example.lunchticketbackend.repository

import com.example.lunchticketbackend.entity.Posts
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PostRepo : CrudRepository<Posts, Long> {
}