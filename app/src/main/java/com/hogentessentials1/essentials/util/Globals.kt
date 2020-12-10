package com.hogentessentials1.essentials.util

import com.auth0.android.jwt.JWT
import java.util.Date

/**
 * @author Simon De Wilde
 * @author Kilian Hoefman
 * @author Ziggy Moens
 *
 * This static class has global properties that can be accessed everywhere in the app
 */
class Globals {
    companion object {
        const val BASE_URL = "https://essentialsapi.azurewebsites.net/api/"

        private var bt = ""

        var bearerToken: String
            get() {
                if (!bearertokenIsValid()) {
                    this.bearerToken = ""
                }

                return bt
            } set(value) {
            this.bt = value
        }

        fun bearertokenIsValid(): Boolean {
            try {
                val jwt = JWT(this.bt)
                jwt.expiresAt?.let {
                    val today = Date()
                    if (it > today) {
                        return true
                    } else {
                        throw Exception()
                    }
                }
            } catch (e: Exception) {
                return false
            }

            return false
        }

        val username: String
            get() {
                try {
                    val jwt = JWT(this.bt)
                    jwt.subject?.let {
                        return it.split(".")[0].split("@")[0]
                    }
                } catch (e: Exception) {
                    return ""
                }
                return ""
            }

        val userid: Int?
            get() {
                try {
                    val jwt = JWT(this.bt)
                    jwt.getClaim("nameid").let {
                        return it.asInt()
                    }
                } catch (e: Exception) {
                    return 0
                }
            }

        val type: String?
            get() {
                try {
                    val jwt = JWT(this.bt)
                    jwt.getClaim("http://schemas.microsoft.com/ws/2008/06/identity/claims/role")
                        .let {
                            return it.asString()
                        }
                } catch (e: Exception) {
                    return ""
                }
            }
    }
}
