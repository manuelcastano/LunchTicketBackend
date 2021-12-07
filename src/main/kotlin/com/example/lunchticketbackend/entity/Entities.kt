package com.example.lunchticketbackend.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.*
import javax.persistence.*

@Entity
@NamedQuery(name = "Student.findAll", query = "SELECT s from Student s")
class Student(
    @Id
    @GeneratedValue
    var userID: Long? = null,
    var studCode: String = "",
    var studName: String = "",
    var studPsswd: String = "",
    var studProfPic: String = "",
    @OneToMany
    var studentLunches: List<Lunch>? = null,
)

@Entity
@NamedQuery(name = "Restaurant.findAll", query = "SELECT r from Restaurant r")
class Restaurant(
    @Id
    @GeneratedValue
    var restID: Long? = null,
    var restNIT: String = "",
    var restName: String = "",
    var restPsswd: String = "",
    var restProfPic: String = "",
    var restSocialReason: String = "",
    var restLat: Long? = null,
    var restLong: Long? = null,
    @OneToMany
    var restuarantLunches: List<Lunch>? = null,
)

@Entity
@NamedQuery(name = "Lunch.findAll", query = "SELECT l from Lunch l")
class Lunch(
    @Id
    @GeneratedValue
    var lunchId: Long? = null,
    var lunchDate: Date = Date(),
    @ManyToOne
    var lunchRestaurant: Lunch? = null,
    @ManyToOne
    var lunchStudent: Student? = null
)

@Entity
@NamedQuery(name = "FinancialOffice.findAll", query = "SELECT f from FinancialOffice f")
class FinancialOffice(
    @Id
    @GeneratedValue
    var finOffId: Long? = null,
    var findOffCode: String = "",
    var finOffDoc: String = "",
    var finOffPsswd: String = "",
    @OneToMany
    var finOffposts: List<Post>? = null,
)

@Entity
@NamedQuery(name = "Post.findAll", query = "SELECT p from Post p")
class Post(
    @Id
    @GeneratedValue
    var postId: Long? = null,
    var postTitle: String = "",
    var postDate: Date? = null,
    @ManyToOne
    var financialOffice: FinancialOffice? = null,
)