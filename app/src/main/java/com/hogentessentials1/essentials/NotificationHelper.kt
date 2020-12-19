package com.hogentessentials1.essentials

import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

/**
 * class for displaying notifications
 *
 * @author Marbod Naassens
 *
 */
class NotificationHelper {
    companion object Displayer {
        fun displayNotification(context: Context, title: String, body: String) {
            val builder: NotificationCompat.Builder = NotificationCompat.Builder(context, MainActivity.CHANNEL_ID).setSmallIcon(R.drawable.ic_logo).setContentTitle(title).setContentText(body).setPriority(NotificationCompat.PRIORITY_DEFAULT)
            val manager: NotificationManagerCompat = NotificationManagerCompat.from(context)
            manager.notify(1, builder.build())
        }
    }
}
