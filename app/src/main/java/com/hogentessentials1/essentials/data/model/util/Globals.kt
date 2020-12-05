package com.hogentessentials1.essentials.data.model.util

import com.auth0.android.jwt.JWT
import java.lang.Exception

class Globals {
    companion object {
        const val BASE_URL = "https://essentialsapi.azurewebsites.net/api/"

        var bearerToken: String = ""

        val username: String
            get() {
                try {
                    val jwt = JWT(bearerToken)
                    jwt.subject?.let {
                        return it.split(".")[0].split("@")[0]
                    }
                } catch (e: Exception) {
                    return ""
                }
                return ""
            }
    }
}
