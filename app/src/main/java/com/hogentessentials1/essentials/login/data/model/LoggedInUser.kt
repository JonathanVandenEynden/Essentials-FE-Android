package com.hogentessentials1.essentials.login.data.model

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
data class LoggedInUser(
    val userId: Number,
    val bearerToken: String,
    val displayName: String
)
