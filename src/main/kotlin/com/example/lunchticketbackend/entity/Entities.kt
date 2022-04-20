package com.example.lunchticketbackend.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import java.io.Serializable

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "PERSON")
@NamedQuery(name = "Person.findAll", query = "SELECT p from Person p")
class Person(

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "PERS_ID")
    var persId : Long? = null,
    @Column(name="PERS_NAME")
    var persName: String = "",
    @Column(name = "PERS_DOCUMENT")
    var persDoc: String = "",
    @Column(name="PERS_STATE")
    var persState: String = "",
    @Column(name="PERS_PROFPIC")
    var persProfPic: String = "",


    @OneToMany(mappedBy = "lunchPerson")
    @JsonIgnore
    var personLunches: List<Lunch>? = null,
    @OneToOne
    @JoinColumn(name = "USERR_USER_ID")
    var userr: Userr? = null,
    @OneToMany(mappedBy = "person")
    @JsonIgnore
    var personRoles: List<PersonRole>? = null,
) : Serializable

@Entity
@Table(name = "ROLEE")
@NamedQuery(name = "Rolee.findAll", query = "SELECT r from Rolee r")
class Rolee(

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ROLE_ID")
    var roleId : Long? = null,
    @Column(name = "ROLE_NAME")
    var roleName : String = "",
    @Column(name = "ROLE_DESCRIPTION")
    var roleDescription : String = "",

    @OneToMany(mappedBy = "role")
    @JsonIgnore
    var roleeRoles: List<PersonRole>? = null,
) : Serializable

@Entity
@Table(name = "PERS_ROLE")
@NamedQuery(name = "PersonRole.findAll", query = "SELECT p from PersonRole p")
class PersonRole(

    @EmbeddedId
    var id: PersonRolePK? = null,

    @ManyToOne
    @JoinColumn(name = "PERSON_PERS_ID", insertable = false, updatable = false)
    var person: Person? = null,
    @ManyToOne
    @JoinColumn(name = "ROLEE_ROLE_ID", insertable = false, updatable = false)
    var role: Rolee? = null,
) : Serializable

@Embeddable
class PersonRolePK(

    @Column(name="PERSON_PERS_ID", insertable = false, updatable = false)
    var personPersonId: Long? = null,
    @Column(name = "ROLEE_ROLE_ID", insertable = false, updatable = false)
    var roleRoleId: Long? = null,
) : Serializable

@Entity
@Table(name = "USERR")
@NamedQuery(name = "Userr.findAll", query = "SELECT u from Userr u")
class Userr(

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "USER_ID")
    var userId : Long? = null,
    @Column(name = "USER_NAME")
    var userName : String = "",
    @Column(name = "USER_DOCUMENT")
    var userDocument : String = "",

    @OneToOne(mappedBy = "userr")
    @JsonIgnore
    var person: Person? = null,

    @OneToOne(mappedBy = "userres")
    @JsonIgnore
    var restaurant: Restaurant? = null,
) : Serializable

@Entity
@Table(name = "RESTAURANT")
@NamedQuery(name = "Restaurant.findAll", query = "SELECT r from Restaurant r")
class Restaurant(

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "REST_ID")
    var restID: Long? = null,
    @Column(name = "REST_NIT")
    var restNIT: String = "",
    @Column(name = "REST_NAME")
    var restName: String = "",
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
    var restaurantLunches: List<Lunch>? = null,

    @OneToOne
    @JoinColumn(name = "USERR_USER_ID")
    var userres: Userr? = null,
) : Serializable

@Entity
@Table(name = "LUNCH")
@NamedQuery(name = "Lunch.findAll", query = "SELECT l from Lunch l")
class Lunch(

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "LUN_ID")
    var lunchId: Int = 0,
    @Column(name = "LUN_DATE")
    var lunchDate: Date = Date(),

    @ManyToOne
    @JoinColumn(name = "RESTAURANT_REST_ID")
    var lunchRestaurant: Restaurant? = null,
    @ManyToOne
    @JoinColumn(name = "PERSON_PERS_ID")
    var lunchPerson: Person? = null
) : Serializable

@Entity
@Table(name = "POST")
@NamedQuery(name = "Post.findAll", query = "SELECT p from Post p")
class Post(

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "PST_ID")
    var postId: Long? = null,
    @Column(name = "PST_TITLE")
    var postTitle: String = "",
    @Column(name = "PST_DESCRIPTION")
    var postDescription: String = "",
    @Column(name = "PST_DATE")
    var postDate: Date? = null,

) : Serializable