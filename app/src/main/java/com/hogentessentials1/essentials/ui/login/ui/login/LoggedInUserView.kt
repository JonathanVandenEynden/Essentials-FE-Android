package com.hogentessentials1.essentials.ui.login.ui.login

import java.io.Serializable

/**
 * User details post authentication that is exposed to the UI
 * @author Simon De Wilde
 *
 * @property displayName
 */

data class LoggedInUserView(
    val displayName: String
) : Serializable
