package com.hogentessentials1.essentials

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

/**
 * Service for the Notifications
 *
 * @author Marbod Naassens
 *
 */
class NotificationService : FirebaseMessagingService() {
    override fun onMessageReceived(p0: RemoteMessage) {
        super.onMessageReceived(p0)

        if (p0.notification != null) {
            val title = p0.notification!!.title
            val message = p0.notification!!.body

            NotificationHelper.displayNotification(applicationContext, title!!, message!!)
        }
    }
}
