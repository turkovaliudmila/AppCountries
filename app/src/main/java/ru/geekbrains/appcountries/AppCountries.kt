package ru.geekbrains.appcountries

import android.app.Application
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router

class AppCountries : Application() {
    companion object Navigation {

        private val cicerone : Cicerone<Router> by lazy {
            Cicerone.create()
        }

        val navigatorHolder = cicerone.getNavigatorHolder()
        val router = cicerone.router

    }
}