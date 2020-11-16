package com.hogentessentials1.essentials.login.data

import com.hogentessentials1.essentials.login.data.model.LoggedInUser
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
            // TODO: handle loggedInUser authentication --> call naar api en bearertoken krijgen
            val fakeUser = LoggedInUser(Random(42).nextInt(), "Sukrit", "bearerToken")
            return Result.Success(fakeUser)
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
        // TODO: revoke authentication --> bearer token uit cache verwijderen
    }
}
