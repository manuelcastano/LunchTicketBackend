package com.example.lunchticketbackend.entity

import com.fasterxml.jackson.annotation.JsonIgnore

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "PERSON")
@NamedQuery(name = "Person.findAll", query = "SELECT p from Person p")
class Person(

    @Id
    @SequenceGenerator(name="PERSON_PERSID_GENERATOR", sequenceName="PERSON_SEQ", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "PERSON_PERSID_GENERATOR")
    @Column(name = "PERS_ID")
    var persId : Long? = null,
    @Column(name="PERS_NAME")
    var persName: String = "",
    @Column(name="PERS_CODE")
    var persCode: String = "",
    @Column(name = "PERS_DOCUMENT")
    var persDoc: String = "",
    @Column(name="PERS_STATE")
    var persState: String = "",
    @Column(name="PERS_PROFPIC")
    var persProfPic: String = "",


    @OneToMany(mappedBy = "lunchPerson")
    @JsonIgnore
    var personLunches: List<Lunch>? = null,
    @OneToMany(mappedBy = "postPerson")
    @JsonIgnore
    var personPosts: List<Post>? = null,
    @OneToOne(mappedBy = "userPerson")
    var personUser: Userr? = null,
    @OneToMany(mappedBy = "person")
    @JsonIgnore
    var personRoles: List<PersonRole>? = null,
)

@Entity
@Table(name = "ROLEE")
@NamedQuery(name = "Rolee.findAll", query = "SELECT r from Rolee r")
class Rolee(

    @Id
    @SequenceGenerator(name="ROLEE_ROLEID_GENERATOR", sequenceName="ROLEE_SEQ", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "ROLEE_ROLEID_GENERATOR")
    @Column(name = "ROLE_ID")
    var roleId : Long? = null,
    @Column(name = "ROLE_NAME")
    var roleName : String = "",
    @Column(name = "ROLE_DESCRIPTION")
    var roleDescription : String = "",

    @OneToMany(mappedBy = "role")
    @JsonIgnore
    var roleeRoles: List<PersonRole>? = null,
)

@Entity
@Table(name = "PERS_ROLE")
@NamedQuery(name = "PersonRole.findAll", query = "SELECT p from PersonRole p")
class PersonRole(

    @ManyToOne
    @JoinColumn(name = "PERSON_PERS_ID")
    var person: Person? = null,
    @ManyToOne
    @JoinColumn(name = "ROLEE_ROLE_ID")
    var role: Rolee? = null,
)

@Entity
@Table(name = "USERR")
@NamedQuery(name = "Userr.findAll", query = "SELECT u from Userr u")
class Userr(

    @Id
    @SequenceGenerator(name="USERR_USERID_GENERATOR", sequenceName="USERR_SEQ", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "USERR_USERID_GENERATOR")
    @Column(name = "USER_ID")
    var userId : Long? = null,
    @Column(name = "USER_NAME")
    var userName : String = "",
    @Column(name = "USER_PSSWD")
    var userPsswd : String = "",

    @OneToOne(mappedBy = "personUser")
    var userPerson : Person? = null,
)

@Entity
@Table(name = "RESTAURANT")
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
@Table(name = "LUNCH")
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
    @JoinColumn(name = "PERSON_PERS_ID")
    var lunchPerson: Person? = null
)

@Entity
@Table(name = "POST")
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
    @JoinColumn(name = "PERSON_PERS_ID")
    var postPerson: Person? = null,
)