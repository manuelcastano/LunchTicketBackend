package com.example.lunchticketbackend.controller

import com.example.lunchticketbackend.service.LunchServiceImplementation
import com.example.lunchticketbackend.service.PersonServiceImplementation
import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.security.spec.KeySpec
import java.util.*
import javax.crypto.Cipher
import javax.crypto.SecretKey
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.PBEKeySpec
import javax.crypto.spec.SecretKeySpec


@RestController
class QRCodeController(val lunchService: LunchServiceImplementation, val personService : PersonServiceImplementation) {

    @Value("\${lunchticket.waittimeseconds}")
    private val waitTimeSeconds: Long = 1

    @Value("\${aes.password}")
    private val password: String = ""

    data class QRCodeWrapper(val studentCode: String, val timestamp: Long)

    @GetMapping("/qrcode")
    fun getQRForUser(@RequestParam("user") username: String): String {
        val wrapper = QRCodeWrapper(username, System.currentTimeMillis() / (1000 * waitTimeSeconds))
        val gson = Gson()
        return encryptAES(gson.toJson(wrapper))
    }

    @GetMapping("/test")
    fun getQRForUser(): String {
//        return ""+lunchService.findAll().size
        return "test"
    }

    @PostMapping("/qrcode")
    fun readQR(@RequestParam("qr") qr: String, @RequestParam("rest") restaurant: String): String {
        try {
            val decrypted = decryptAES(qr)
            val gson = Gson()
            val wrapper = gson.fromJson(decrypted, QRCodeWrapper::class.java)
            val studentCode = wrapper.studentCode
            val timestamp = wrapper.timestamp
//            val stud = personService.findPersByCode(studentCode)
            lunchService.create(studentCode, restaurant, timestamp)
            return studentCode
        } catch (e: Exception) {
            e.printStackTrace()
            throw ResponseStatusException(HttpStatus.BAD_REQUEST)
        }

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