package com.hogentessentials.essentials.ui.login.ui.login

/**
 * @author Simon De Wilde
 *
 * Authentication result : success (user details) or error message.
 */
data class LoginResult(
    val success: LoggedInUserView? = null,
    val error: Int? = null
)
