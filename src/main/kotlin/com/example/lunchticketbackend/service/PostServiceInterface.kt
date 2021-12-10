package com.example.lunchticketbackend.service

import com.example.lunchticketbackend.entity.Post

interface PostServiceInterface {
    fun findAll():List<Post>
    fun findPostById(postId:Long):Post
}