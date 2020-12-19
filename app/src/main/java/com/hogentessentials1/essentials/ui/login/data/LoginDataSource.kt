package com.hogentessentials1.essentials.ui.login.data

import com.hogentessentials1.essentials.data.network.AccountEndpointInterface
import com.hogentessentials1.essentials.data.network.BaseDataSource
import com.hogentessentials1.essentials.ui.login.data.model.LoggedInUser
import com.hogentessentials1.essentials.util.Globals
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import timber.log.Timber
import java.io.IOException

/**
 * @author Simon De Wilde
 *
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource(val aApiService: AccountEndpointInterface) : BaseDataSource() {

    suspend fun login(username: String, password: String): Result<LoggedInUser> {
        try {

            val response = aApiService.login(getRequestBody(username, password))

            if (response.isSuccessful) {
                val body = response.body()!!.charStream().readText()
                val bearer = body.removePrefix("\"").removeSuffix("\"")
                Timber.i(bearer)
                Globals.bearerToken = bearer

                val user = LoggedInUser(Globals.username)
                return Result.Success(user)
            } else {
                throw Exception()
            }
        } catch (e: Exception) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
        Globals.bearerToken = ""
    }

    private fun getRequestBody(username: String, password: String): RequestBody {
        val jsonObject = JSONObject()
        jsonObject.put("email", username)
        jsonObject.put("password", password)
        return jsonObject.toString().toRequestBody("application/json".toMediaTypeOrNull())
    }
}
