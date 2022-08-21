package com.example.lunchticketbackend.controller

import com.example.lunchticketbackend.service.PostServiceInterface
import com.example.lunchticketbackend.entity.Posts
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class PostControllerImplementation(val postService: PostServiceInterface): PostControllerInterface {

    @GetMapping("/getPosts")
    override fun getPosts(): List<Posts> {
        return postService.findAll()
    }

    @PostMapping("/addPost")
    override fun addPost(@RequestParam("title") title: String, @RequestParam("body") body: String, @RequestParam("date_post") date_post: String) {
        return postService.addPost(title, body, date_post)
    }
}