package org.andcoe.recipeapp.core

import android.app.Application
import org.andcoe.recipeapp.BuildConfig
import timber.log.Timber

open class App : Application() {

    lateinit var appModule: AppModule

    override fun onCreate() {
        super.onCreate()
        appModule = ProdAppModule()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}