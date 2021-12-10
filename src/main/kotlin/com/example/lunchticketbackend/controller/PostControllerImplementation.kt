package com.example.lunchticketbackend.controller

import com.example.lunchticketbackend.service.PostServiceInterface
import com.example.lunchticketbackend.entity.Post
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PostControllerImplementation(val postService: PostServiceInterface): PostControllerInterface {

    @GetMapping("/posts")
    override fun getPosts(): List<Post> {
        return postService.findAll()
    }
}