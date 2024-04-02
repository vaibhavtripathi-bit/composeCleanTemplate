package com.example.composecleanacrhitecture.app

import android.app.Application
import android.os.StrictMode
import com.example.composecleanacrhitecture.di.appComponent
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class CAApplicationClass : Application() {

    override fun onCreate() {
        //initStrictMode()
        super.onCreate()
        initKoin()
    }

    private fun initStrictMode() {
        StrictMode.setThreadPolicy(
            StrictMode.ThreadPolicy.Builder()
                .detectDiskReads()
                .detectDiskWrites()
                .detectNetwork() // or .detectAll() for all detectable problems
                .penaltyLog()
                .build()
        )
        StrictMode.setVmPolicy(
            StrictMode.VmPolicy.Builder()
                .detectLeakedSqlLiteObjects()
                .detectLeakedClosableObjects()
                .penaltyLog()
                .penaltyDeath()
                .build()
        )
    }

    private fun initKoin() {
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@CAApplicationClass)
            modules(provideDependency())
        }
    }

    //List of Koin dependencies
    private fun provideDependency() = appComponent
}