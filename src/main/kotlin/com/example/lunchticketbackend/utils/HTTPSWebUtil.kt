
import java.net.HttpURLConnection
import java.net.URL
import javax.net.ssl.*


class HTTPSWebUtil {

    fun GETRequest(url: String): String {
        val url = URL(url)
        val client = url.openConnection() as HttpsURLConnection
        client.requestMethod = "GET"
        return client.inputStream.bufferedReader().readText()
    }

    fun POSTRequest(url: String, json: String): String {
        val url = URL(url)
        val client = url.openConnection() as HttpsURLConnection
        client.requestMethod = "POST"
        client.setRequestProperty("Content-Type", "application/json")
        client.doOutput = true
        client.outputStream.bufferedWriter().use {
            it.write(json)
            it.flush()
        }
        return client.inputStream.bufferedReader().readText()
    }

    fun POSTtoFCM(json: String): String {
        val url = URL("https://fcm.googleapis.com/fcm/send")
        val client = url.openConnection() as HttpsURLConnection
        client.requestMethod = "POST"
        client.setRequestProperty("Content-Type", "application/json")
        client.setRequestProperty("Authorization", "key=$FCM_KEY")
        client.doOutput = true
        client.outputStream.bufferedWriter().use {
            it.write(json)
            it.flush()
        }
        return client.inputStream.bufferedReader().readText()
    }

    fun PUTRequest(url: String, json: String): String {
        val url = URL(url)
        val client = url.openConnection() as HttpsURLConnection
        client.requestMethod = "PUT"
        client.setRequestProperty("Content-Type", "application/json")
        client.doOutput = true
        client.outputStream.bufferedWriter().use {
            it.write(json)
            it.flush()
        }
        return client.inputStream.bufferedReader().readText()
    }

    fun DELETERequest(url: String): String {
        val url = URL(url)
        val client = url.openConnection() as HttpsURLConnection
        client.requestMethod = "DELETE"
        return client.inputStream.bufferedReader().readText()
    }


    companion object {
        const val FCM_KEY:String = "AAAAJ5c2PXM:APA91bGIFBoe7p4y05b6xmxC3vY4EBKHMG8AU1DUVzDWJcL9WvuQuZcHHj-2k5SIwEnJiFZdTlycETQjsla5wgL9UD2MMun4Eoip3hizWBsGSkVJ3SrmSFtkyWShUks0Xy9lQdNBsYuW"
    }


}