package com.example.ourtodo

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.example.ourtodo.data.preference.PreferenceManager
import com.example.ourtodo.di.appModule
import com.example.ourtodo.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level

class OurToDoApplication : Application() {

    override fun onCreate() {
        prefs = PreferenceManager(applicationContext)
        super.onCreate()
        appContext = this

        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@OurToDoApplication)
            modules(appModule, viewModelModule)
        }
    }

    override fun onTerminate() {
        super.onTerminate()
        appContext = null
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var prefs: PreferenceManager
        var appContext: Context? = null
            private set
    }

}