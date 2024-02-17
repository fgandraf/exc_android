
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response

class ApiRequest {


    fun login(model: LoginRequest): String {
        val client = OkHttpClient()
        val url = "https://promore.azurewebsites.net/v1/users/login"
        val mediaType = "application/json; charset=utf-8".toMediaTypeOrNull()
        val body = Json.encodeToString(model).toRequestBody(mediaType)
        val request = Request.Builder().url(url).post(body).build()

        return client.newCall(request).execute().body!!.string()
    }



    fun get(endpoint: String, token: String): Response {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url("https://promore.azurewebsites.net/$endpoint")
            .addHeader("Authorization", "Bearer $token")
            .get()
            .build()

        return client.newCall(request).execute()
    }



    inline fun <reified T : Any> post(model: T, endpoint : String, token: String) : Response {
        val client = OkHttpClient()
        val url = "https://promore.azurewebsites.net/$endpoint"
        val mediaType = "application/json; charset=utf-8".toMediaTypeOrNull()
        val body = Json.encodeToString(model).toRequestBody(mediaType)

        val request = Request.Builder()
            .url(url)
            .addHeader("Authorization", "Bearer $token")
            .post(body)
            .build()

        return client.newCall(request).execute()
    }



    inline fun <reified T : Any> put(model: T, endpoint : String, token: String) : Response {
        val client = OkHttpClient()
        val url = "https://promore.azurewebsites.net/$endpoint"
        val mediaType = "application/json; charset=utf-8".toMediaTypeOrNull()
        val body = Json.encodeToString(model).toRequestBody(mediaType)

        val request = Request.Builder()
            .url(url)
            .addHeader("Authorization", "Bearer $token")
            .put(body)
            .build()

        return client.newCall(request).execute()
    }


    fun delete(endpoint: String, param: String, token: String): Response {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url("https://promore.azurewebsites.net/$endpoint/$param")
            .addHeader("Authorization", "Bearer $token")
            .delete()
            .build()

        return client.newCall(request).execute()
    }


}