package com.example.lunchticketbackend.controller

import com.example.lunchticketbackend.model.BooleanResponse
import com.example.lunchticketbackend.model.Document
import com.example.lunchticketbackend.model.Lunch
import com.example.lunchticketbackend.service.LunchServiceImplementation
import com.example.lunchticketbackend.service.StudentServiceInterface
import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.ByteArrayResource
import org.springframework.core.io.Resource
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.server.ResponseStatusException
import java.security.spec.KeySpec
import java.util.*
import javax.crypto.Cipher
import javax.crypto.SecretKey
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.PBEKeySpec
import javax.crypto.spec.SecretKeySpec


@RestController
class QRCodeController(val lunchService: LunchServiceImplementation, val studentService: StudentServiceInterface) {

    @Value("\${lunchticket.waittimeseconds}")
    private val waitTimeSeconds: Long = 1

    @Value("\${aes.password}")
    private val password: String = ""

    data class QRCodeWrapper(val studentCode: String, val timestamp: Long)

    @GetMapping("/qrcode")
    fun getQRForUser(@RequestParam("document") document: String): BooleanResponse {
        var inTime = lunchService.inTime()
        var hasImageUpdated = studentService.hasImageUpdated(document)
        var hasAlreadyLunch = lunchService.hasAlreadyLunch(document)
        if(!inTime){
            return BooleanResponse(false, "No estas dentro del tiempo establecido para obtener tu almuerzo")
        } else if(!hasImageUpdated.response){
            return hasImageUpdated
        } else if(hasAlreadyLunch.response){
            return BooleanResponse(false, "Ya obtuviste tu almuerzo el día de hoy")
        } else{
            val wrapper = QRCodeWrapper(document, System.currentTimeMillis() / (1000 * waitTimeSeconds))
            val gson = Gson()
            return BooleanResponse(true, encryptAES(gson.toJson(wrapper)))
        }
    }

    //Retorna la imagen del estudiante que pide el almuerzo
    @GetMapping(value = ["/qrInformation"], produces = [MediaType.IMAGE_JPEG_VALUE])
    fun qrInformation(@RequestParam("qr") qr: String): ResponseEntity<Resource?>? {
        try {
            val decrypted = decryptAES(qr)
            val gson = Gson()
            val wrapper = gson.fromJson(decrypted, QRCodeWrapper::class.java)
            val studentCode = wrapper.studentCode
            val timestamp = wrapper.timestamp
            //lunchService.create(studentCode, nit, timestamp)
            return studentService.getImage(studentCode)
        } catch (e: Exception) {
            var response = ByteArrayResource("Por favor intentalo más tarde".toByteArray())
            return ResponseEntity
                .status(HttpStatus.OK)
                .contentLength(response.contentLength())
                .body(response)
        }
    }


    @PostMapping("/lunchSave")
    fun saveLunch(@RequestBody body: String): BooleanResponse {
        var json = Gson()
        var lunch: Lunch = json.fromJson(body, Lunch::class.java)
        return lunchService.saveLunch(lunch.studentCode, lunch.nit, lunch.accepted)
    }


    private fun encryptAES(text: String): String {
        val factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256")
        val salt = ByteArray(8)
        val spec: KeySpec = PBEKeySpec(password.toCharArray(), salt, 65536, 256)
        val tmp = factory.generateSecret(spec)
        val secret: SecretKey = SecretKeySpec(tmp.encoded, "AES")
        val cipher: Cipher = Cipher.getInstance("AES")
        cipher.init(Cipher.ENCRYPT_MODE, secret)
        val encrypted = cipher.doFinal(text.toByteArray())
        return encrypted.toHex()
    }

    private fun decryptAES(text: String): String {
        val factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256")
        val salt = ByteArray(8)
        val spec: KeySpec = PBEKeySpec(password.toCharArray(), salt, 65536, 256)
        val tmp = factory.generateSecret(spec)
        val secret: SecretKey = SecretKeySpec(tmp.encoded, "AES")
        val cipher: Cipher = Cipher.getInstance("AES")
        cipher.init(Cipher.DECRYPT_MODE, secret)
        val decrypted = cipher.doFinal(text.decodeHex())
        return String(decrypted)
    }

    fun ByteArray.toHex(): String = joinToString(separator = "") { eachByte -> "%02x".format(eachByte) }

    fun String.decodeHex(): ByteArray {
        return chunked(2)
            .map { it.toInt(16).toByte() }
            .toByteArray()
    }
}