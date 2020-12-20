package com.hogentessentials1.essentials.ui.login.ui.login

/**
 * Data validation state of the login form.
 * @author Simon De Wilde
 *
 * @property usernameError
 * @property passwordError
 * @property isDataValid
 */
data class LoginFormState(
    val usernameError: Int? = null,
    val passwordError: Int? = null,
    val isDataValid: Boolean = false
)
