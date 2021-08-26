package ru.geekbrains.appcountries.view

import android.R
import android.os.Bundle
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import ru.geekbrains.appcountries.AppCountries.Navigation.navigatorHolder
import ru.geekbrains.appcountries.AppCountries.Navigation.router

class MainActivity : MvpAppCompatActivity() {

    private val navigator = AppNavigator(this, R.id.content)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedInstanceState ?: router.newRootScreen(AppScreens.countries())
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}