package com.hogentessentials1.essentials

import android.app.Application
import com.hogentessentials1.essentials.DI.networkModule
import com.hogentessentials1.essentials.DI.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

/**
 * The application class of the application, called in the androidManifest.
 * This starts Koin (DI) with the right modules and loggers and plants a Timber debug tree
 *
 * @author Simon De Wilde
 * @author Killian Hoefman
 *
 */
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(
                networkModule,
                viewModelModule
            )
        }
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
