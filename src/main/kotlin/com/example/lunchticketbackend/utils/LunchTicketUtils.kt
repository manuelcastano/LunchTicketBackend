package com.example.lunchticketbackend.utils

import org.slf4j.LoggerFactory
import java.lang.Exception
import java.util.*
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.PBEKeySpec
import javax.xml.bind.DatatypeConverter
import kotlin.random.Random

class LunchTicketUtils {

    companion object {
        @JvmStatic
        private val logger = LoggerFactory.getLogger(LunchTicketUtils::class.java)
    }

    fun getPasswordHash(pwd:String): String {
        return try {
            val random = Random(152389161)
            val salt = ByteArray(16)
            random.nextBytes(salt)
            val spec = PBEKeySpec(pwd.toCharArray(), salt, 65536, 128)
            val factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1")
            val hash = factory.generateSecret(spec).encoded
            DatatypeConverter.printHexBinary(hash).uppercase(Locale.getDefault())
        } catch (e: Exception) {
            logger.error("Error while trying to encrypt password: ${e.message}")
            pwd
        }
    }

}