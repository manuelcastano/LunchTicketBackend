package com.example.lunchticketbackend.service

import com.example.lunchticketbackend.entity.Posts

interface PostServiceInterface {
    fun findAll():List<Posts>
    fun findPostById(postId:Long):Posts
    abstract fun addPost(title: String, body: String, datePost: String)
}