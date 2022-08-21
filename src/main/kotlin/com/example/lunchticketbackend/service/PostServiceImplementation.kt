package com.example.lunchticketbackend.service

import com.example.lunchticketbackend.entity.Posts
import com.example.lunchticketbackend.entity.Userr
import com.example.lunchticketbackend.repository.PostRepo
import org.springframework.stereotype.Service

@Service
class PostServiceImplementation(val postRepo: PostRepo):PostServiceInterface {

    override fun findAll(): List<Posts> {
        return postRepo.findAll() as List<Posts>
    }

    override fun findPostById(postId: Long): Posts {
        return postRepo.findById(postId).get()
    }

    override fun addPost(title: String, body: String, datePost: String) {
        var post = Posts(0, title, body, datePost)
        postRepo.save(post)
    }
}