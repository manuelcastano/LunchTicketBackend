package com.example.lunchticketbackend.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.*
import javax.persistence.*

@Entity
@NamedQuery(name = "Student.findAll", query = "SELECT s from Student s")
class Student(
    @Id
    @SequenceGenerator(name="STUDENT_STUDID_GENERATOR", sequenceName="STUDENT_SEQ", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "STUDENT_STUDID_GENERATOR")
    @Column(name="STUD_ID")
    var studId: Long? = null,
    @Column(name="STUD_CODE")
    var studCode: String = "",
    @Column(name="STUD_NAME")
    var studName: String = "",
    @Column(name="STUD_PSSWD")
    var studPsswd: String = "",
    @Column(name="STUD_PROFPIC")
    var studProfPic: String = "",
    @Column(name="STUD_STATE")
    var studState: String = "",
    @OneToMany(mappedBy = "lunchStudent")
    @JsonIgnore
    var studentLunches: List<Lunch>? = null,
)

@Entity
@NamedQuery(name = "Restaurant.findAll", query = "SELECT r from Restaurant r")
class Restaurant(
    @Id
    @SequenceGenerator(name="RESTAURANT_RESTID_GENERATOR", sequenceName="RESTAURANT_SEQ", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "RESTAURANT_RESTID_GENERATOR")
    @Column(name = "REST_ID")
    var restID: Long? = null,
    @Column(name = "REST_NIT")
    var restNIT: String = "",
    @Column(name = "REST_NAME")
    var restName: String = "",
    @Column(name = "REST_USERNAME")
    var restUserName: String = "",
    @Column(name = "REST_PSSWD")
    var restPsswd: String = "",
    @Column(name = "REST_PROFPIC")
    var restProfPic: String = "",
    @Column(name = "REST_SOCIALREASON")
    var restSocialReason: String = "",
    @Column(name = "REST_LAT")
    var restLat: Long? = null,
    @Column(name = "REST_LONG")
    var restLong: Long? = null,
    @OneToMany(mappedBy = "lunchRestaurant")
    @JsonIgnore
    var restuarantLunches: List<Lunch>? = null,
)

@Entity
@NamedQuery(name = "Lunch.findAll", query = "SELECT l from Lunch l")
class Lunch(
    @Id
    @SequenceGenerator(name="LUNCH_LUNID_GENERATOR", sequenceName="LUNCH_SEQ", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "LUNCH_LUNID_GENERATOR")
    @Column(name = "LUN_ID")
    var lunchId: Long? = null,
    @Column(name = "LUN_DATE")
    var lunchDate: Date = Date(),
    @ManyToOne
    @JoinColumn(name = "RESTAURANT_REST_ID")
    var lunchRestaurant: Lunch? = null,
    @ManyToOne
    @JoinColumn(name = "STUDENT_STUD_ID")
    var lunchStudent: Student? = null
)

@Entity
@NamedQuery(name = "FinancialOffice.findAll", query = "SELECT f from FinancialOffice f")
class FinancialOffice(
    @Id
    @SequenceGenerator(name="FINANCIALOFFICE_FINOFFID_GENERATOR", sequenceName="FINANCIALOFFICE_SEQ", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "FINANCIALOFFICE_FINOFFID_GENERATOR")
    @Column(name = "FINOFF_ID")
    var finOffId: Long? = null,
    @Column(name = "FINOFF_CODE")
    var findOffCode: String = "",
    @Column(name = "FINOFF_DOCUMENT")
    var finOffDoc: String = "",
    @Column(name = "FINOFF_NAME")
    var finOffName: String = "",
    @Column(name = "FINOFF_PSSWD")
    var finOffPsswd: String = "",
    @OneToMany(mappedBy = "")
    @JsonIgnore
    var finOffposts: List<Post>? = null,
)

@Entity
@NamedQuery(name = "Post.findAll", query = "SELECT p from Post p")
class Post(
    @Id
    @SequenceGenerator(name="POST_PSTID_GENERATOR", sequenceName="POST_SEQ", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "POST_PSTID_GENERATOR")
    @Column(name = "PST_ID")
    var postId: Long? = null,
    @Column(name = "PST_TITLE")
    var postTitle: String = "",
    @Column(name = "PST_DESCRIPTION")
    var postDescription: String = "",
    @Column(name = "PST_DATE")
    var postDate: Date? = null,
    @ManyToOne
    @JoinColumn(name = "FINANCIALOFFICE_FINOFF_ID")
    var financialOffice: FinancialOffice? = null,
)