package com.hogentessentials1.essentials.login.data

import com.auth0.android.jwt.JWT
import com.hogentessentials1.essentials.login.data.model.LoggedInUser
import com.hogentessentials1.essentials.util.Globals
import java.io.IOException
import kotlin.random.Random

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

            Globals.bearerToken = response;

            val fakeUser = LoggedInUser( Globals.username)
            return Result.Success(fakeUser)
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
        Globals.bearerToken = "";
    }
}
