package com.hogentessentials1.essentials.util

import com.auth0.android.jwt.JWT
import java.lang.Exception

class Globals {
    companion object{
        var bearerToken: String = "";

        val username: String
            get() {
                try{
                    val jwt = JWT(bearerToken)
                    jwt.subject?.let {
                        return it
                    }
                } catch (e:Exception){
                    return ""
                }
                return ""
            }
    }
}