package com.hogentessentials1.essentials.login.data

import com.hogentessentials1.essentials.data.model.util.Globals
import com.hogentessentials1.essentials.login.data.model.LoggedInUser
import java.io.IOException

/**
 * @author Simon De Wilde
 *
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    fun login(username: String, password: String): Result<LoggedInUser> {
        try {
            val response = "" // todo retrofit call naar be

            // Todo checken of het gelukt is

            Globals.bearerToken = response

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
