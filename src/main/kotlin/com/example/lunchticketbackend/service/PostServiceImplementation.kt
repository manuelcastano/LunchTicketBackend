package com.example.lunchticketbackend.service

import com.example.lunchticketbackend.entity.Post
import com.example.lunchticketbackend.repository.PostRepo
import org.springframework.stereotype.Service

@Service
class PostServiceImplementation(val postRepo: PostRepo):PostServiceInterface {

    override fun findAll(): List<Post> {
        return postRepo.findAll() as List<Post>
    }

    override fun findPostById(postId: Long): Post {
        return postRepo.findById(postId).get()
    }
}