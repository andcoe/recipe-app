package org.andcoe.espresso

import org.andcoe.recipeapp.core.App

class EspressoApp : App() {

    override fun onCreate() {
        super.onCreate()
        appModule = TestAppModule()
    }
}