package com.hogentessentials1.essentials.login.ui.login

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
