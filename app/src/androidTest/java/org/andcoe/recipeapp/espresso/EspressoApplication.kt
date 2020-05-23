package org.andcoe.recipeapp.espresso

import org.andcoe.recipeapp.core.App

class EspressoApplication : App() {

    override fun onCreate() {
        super.onCreate()
        appModule = TestAppModule()
    }
}