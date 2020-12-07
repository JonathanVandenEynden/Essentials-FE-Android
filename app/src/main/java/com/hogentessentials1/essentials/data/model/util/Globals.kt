package com.hogentessentials1.essentials.data.model.util

import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.auth0.android.jwt.JWT
import com.hogentessentials1.essentials.MainActivity
import java.lang.Exception
import java.time.LocalDateTime
import java.util.*

/**
 * @author Simon De Wilde
 * @author Kilian Hoefman
 * @author Ziggy Moens
 *
 * This cstatic class has global properties that can be accessed everywhere in the app
 */
class Globals {
    companion object {
        const val BASE_URL = "https://essentialsapi.azurewebsites.net/api/"

        private var bt = ""

        var bearerToken: String
            get() {
                if (!isValid()) {
                    this.bearerToken = "";
                }

                return bt;
            }set(value) {
                this.bt = value
            }

        fun isValid(): Boolean {
            try {
                val jwt = JWT(this.bt)
                jwt.expiresAt?.let {
                    var today = Date()
                    if (it > today) {
                        return true
                    } else {
                        throw Exception();
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
    }
}
