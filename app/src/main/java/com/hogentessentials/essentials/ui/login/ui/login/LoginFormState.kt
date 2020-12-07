package com.hogentessentials.essentials.ui.login.ui.login

/**
 * @author Simon De Wilde
 *
 * Data validation state of the login form.
 */
data class LoginFormState(
    val usernameError: Int? = null,
    val passwordError: Int? = null,
    val isDataValid: Boolean = false
)
