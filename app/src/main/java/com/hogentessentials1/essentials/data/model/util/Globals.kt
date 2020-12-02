package com.hogentessentials1.essentials.data.model.util

import com.auth0.android.jwt.JWT

class Globals {
    companion object {
        const val BASE_URL = "https://essentialsapi.azurewebsites.net/api/"

        var bearerToken: String = ""

        val username: String
            get() {
                try {
                    val jwt = JWT(bearerToken)
                    jwt.subject?.let {
                        return it
                    }
                } catch (e: Exception) {
                    return ""
                }
                return ""
            }

        val userid: Int?
            get() {
                try {
                    val jwt = JWT(bearerToken)
                    jwt.getClaim("nameid").let {
                        return it.asInt()
                    }
                } catch (e: Exception) {
                    return 0
                }
            }
    }
}
