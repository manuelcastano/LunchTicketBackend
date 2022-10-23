package com.example.lunchticketbackend.controller

import com.example.lunchticketbackend.entity.Student
import com.example.lunchticketbackend.model.AddScholarship
import com.example.lunchticketbackend.model.BooleanResponse
import com.example.lunchticketbackend.model.Document
import com.example.lunchticketbackend.model.EditScholarship
import com.example.lunchticketbackend.service.StudentServiceInterface
import com.google.gson.Gson
import org.springframework.core.io.ByteArrayResource
import org.springframework.core.io.Resource
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths


@RestController
@CrossOrigin
class StudentControllerImplementation(val studentService: StudentServiceInterface): StudentControllerInterface{

    @PostMapping("/addScholarship")
    override fun addScholarship(@RequestBody body: String): BooleanResponse{
        var json = Gson()
        var toAdd: AddScholarship = json.fromJson(body, AddScholarship::class.java)
        return studentService.addScholarship(toAdd.document, toAdd.scholarshipName)
    }

    @PostMapping("/deactivateScholarship")
    override fun deactivateScholarship(@RequestBody body: String): BooleanResponse {
        var json = Gson()
        var student: Document = json.fromJson(body, Document::class.java)
        return studentService.deactivateScholarship(student.id)
    }

    @PostMapping("/editScholarship")
    override fun editScholarship(@RequestBody body: String): BooleanResponse {
        var json = Gson()
        var info: EditScholarship = json.fromJson(body, EditScholarship::class.java)
        return studentService.editScholarship(info)
    }

    @PostMapping("/deactivateStudent")
    override fun deactivateStudent(@RequestBody body: String): BooleanResponse {
        var json = Gson()
        var student: Document = json.fromJson(body, Document::class.java)
        return studentService.deactivateScholarship(student.id)
    }

    @GetMapping("/students")
    override fun getAllStudents(): List<Student> {
        return studentService.findAll()
    }

    @PostMapping("/addStudent")
    override fun addStudent(@RequestBody body: String): BooleanResponse {
        var json = Gson()
        var student: com.example.lunchticketbackend.model.Student = json.fromJson(body, com.example.lunchticketbackend.model.Student::class.java)
        return studentService.addStudent(student)
    }

    @PostMapping("/getStudent")
    override fun getStudent(@RequestBody body: String): Student? {
        var json = Gson()
        var document: String = json.fromJson(body, Document::class.java).id
        return studentService.findStudentByUsername(document)
    }

    @PostMapping("/student/uploadPicture")
    override fun uploadPicture(@RequestParam document: String, @RequestParam("image") image: MultipartFile): BooleanResponse {
        return studentService.uploadPicture(document, image)
    }

    @PostMapping(value = ["/student/getImage"], produces = [MediaType.IMAGE_JPEG_VALUE])
    @Throws(IOException::class)
    override fun getImage(@RequestParam("id") id: String): ResponseEntity<Resource?>? {
        return studentService.getImage(id)
    }

    @PostMapping("/hasImageUpdated")
    override fun hasImageUpdated(@RequestBody body: String): BooleanResponse {
        var json = Gson()
        var document: String = json.fromJson(body, Document::class.java).id
        return studentService.hasImageUpdated(document)
    }
}