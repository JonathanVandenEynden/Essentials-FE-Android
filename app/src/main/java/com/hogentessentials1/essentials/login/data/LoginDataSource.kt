package com.hogentessentials1.essentials.login.data

import com.hogentessentials1.essentials.data.model.network.AccountEndpointInterface
import com.hogentessentials1.essentials.data.model.network.BaseDataSource
import com.hogentessentials1.essentials.data.model.network.ChangeGroupEndpointInterface
import com.hogentessentials1.essentials.data.model.util.Globals
import com.hogentessentials1.essentials.login.data.model.LoggedInUser
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
            val jsonObject = JSONObject()
            jsonObject.put("email", username)
            jsonObject.put("password", password)
            val jsonObjectString = jsonObject.toString()
            val requestBody = jsonObjectString.toRequestBody("application/json".toMediaTypeOrNull())


            val response =  aApiService.login(requestBody)
            Timber.e(response.message())

            // Todo checken of het gelukt is

            Globals.bearerToken = response.message()

            val fakeUser = LoggedInUser(Globals.username)
            return Result.Success(fakeUser)
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
        Globals.bearerToken = ""
    }
}
