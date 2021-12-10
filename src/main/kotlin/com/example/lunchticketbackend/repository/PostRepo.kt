package com.example.lunchticketbackend.repository

import com.example.lunchticketbackend.entity.Post
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PostRepo : CrudRepository<Post, Long> {
}