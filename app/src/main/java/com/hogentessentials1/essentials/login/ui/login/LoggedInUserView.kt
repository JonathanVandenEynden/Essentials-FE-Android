package com.hogentessentials1.essentials.login.ui.login

import java.io.Serializable

/**
 * @author Simon De Wilde
 *
 * User details post authentication that is exposed to the UI
 */

data class LoggedInUserView(
    val displayName: String
) : Serializable
