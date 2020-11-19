package com.hogentessentials1.essentials.login.data.model

/**
 * @author Simon De Wilde
 *
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
data class LoggedInUser(
    val userId: Number,
    val displayName: String,
    val bearerToken: String
)
