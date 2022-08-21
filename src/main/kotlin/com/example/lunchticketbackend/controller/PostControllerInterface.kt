package com.example.lunchticketbackend.controller

import com.example.lunchticketbackend.entity.Posts

interface PostControllerInterface {
    fun getPosts():List<Posts>
    fun addPost(title: String, body: String, date_post: String)
}