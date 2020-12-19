package com.hogentessentials1.essentials.ui.login.ui.login

/**
 * Authentication result : success (user details) or error message.
 * @author Simon De Wilde
 *
 * @property success
 * @property error
 */
data class LoginResult(
    val success: LoggedInUserView? = null,
    val error: Int? = null
)
