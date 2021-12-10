package com.example.lunchticketbackend.controller

import com.example.lunchticketbackend.entity.Post

interface PostControllerInterface {
    fun getPosts():List<Post>
}