package com.example.lunchticketbackend.entity

import java.io.Serializable

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "EMPLOYEE_R")
@NamedQuery(name = "Employee_R.findAll", query = "SELECT e from Employee_R e")
class Employee_R(

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    var id: Int? = null,
    @Column(name = "NAME")
    var name: String = "",
    @Column(name = "LAST_NAME")
    var last_name: String = "",
    @Column(name = "DOCUMENT")
    var document: String = "",
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    var userID: Userr? = null,

): Serializable

@Entity
@Table(name = "LUNCH")
@NamedQuery(name = "Lunch.findAll", query = "SELECT l from Lunch l")
class Lunch(

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    var id: Int? = null,
    @Column(name = "DATE_LUNCH")
    var dateLunch: String = "",
    @Column(name = "ACCEPTED")
    var accepted: String = "",
    @ManyToOne
    @JoinColumn(name = "STUDENT_ID")
    var studentID: Student? = null,
    @ManyToOne
    @JoinColumn(name = "RESTAURANT_ID")
    var restaurantID: Restaurant? = null,
): Serializable

@Entity
@Table(name = "MEMBER_AF")
@NamedQuery(name = "Member_AF.findAll", query = "SELECT m from Member_AF m")
class Member_AF(

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    var id: Int? = null,
    @Column(name = "NAME")
    var name: String = "",
    @Column(name = "LAST_NAME")
    var last_name: String = "",
    @Column(name = "IS_SUPER_ADMIN")
    var is_super_admin: String = "",
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    var userID: Userr? = null,
): Serializable

@Entity
@Table(name = "POSTS")
@NamedQuery(name = "Posts.findAll", query = "SELECT p from Posts p")
class Posts(

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    var id: Int? = null,
    @Column(name = "TITLE")
    var title: String = "",
    @Column(name = "BODY")
    var body: String = "",
    @Column(name = "DATE_POST")
    var date_post: String = "",
): Serializable

@Entity
@Table(name = "RESTAURANT")
@NamedQuery(name = "Restaurant.findAll", query = "SELECT r from Restaurant r")
class Restaurant(

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    var id: Int? = null,
    @Column(name = "NAME")
    var name: String = "",
    @Column(name = "NIT")
    var nit: String = "",
    @Column(name = "PROFILE_PIC_URL")
    var profile_pic_url: String = "",
): Serializable

@Entity
@Table(name = "SCHOLARSHIP_NAME")
@NamedQuery(name = "Scholarship_name.findAll", query = "SELECT s from Scholarship_name s")
class Scholarship_name(

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    var id: Int? = null,
    @Column(name = "NAME")
    var name: String = "",
): Serializable

@Entity
@Table(name = "SCHOLARSHIP_REGISTRY")
@NamedQuery(name = "Scholarship_registry.findAll", query = "SELECT s from Scholarship_registry s")
class Scholarship_registry(

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    var id: Int? = null,
    @Column(name = "START_DATE")
    var start_date: String = "",
    @Column(name = "END_DATE")
    var end_date: String = "",
    @Column(name = "ACTIVE")
    var active: String = "",
    @ManyToOne
    @JoinColumn(name = "SCHOLARSHIP_NAME")
    var scholarshipName: Scholarship_name? = null,
    @ManyToOne
    @JoinColumn(name = "STUDENT_ID")
    var studentID: Student? = null,
): Serializable

@Entity
@Table(name = "STUDENT")
@NamedQuery(name = "Student.findAll", query = "SELECT s from Student s")
class Student(

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    var id: Int? = null,
    @Column(name = "DOCUMENT")
    var document: String = "",
    @Column(name = "CODE")
    var code: String = "",
    @Column(name = "NAME")
    var name: String = "",
    @Column(name = "LAST_NAME")
    var lastName: String = "",
    @Column(name = "PROFILE_PIC_URL")
    var profile_pic_url: String = "",
    @Column(name = "ACTIVE")
    var active: String = "",
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    var userID: Userr? = null,
): Serializable

@Entity
@Table(name = "USER_TYPE")
@NamedQuery(name = "User_type.findAll", query = "SELECT u from User_type u")
class User_type(

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    var id: Int? = null,
    @Column(name = "ROLE")
    var role: String = "",
): Serializable

@Entity
@Table(name = "USERR")
@NamedQuery(name = "Userr.findAll", query = "SELECT u from Userr u")
class Userr(

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    var id: Int? = null,
    @Column(name = "DOCUMENT")
    var document: String = "",
    @Column(name = "PASSWORD")
    var password: String = "",
    @ManyToOne
    @JoinColumn(name = "USER_TYPE")
    var userType: User_type? = null,
): Serializable
