package ru.geekbrains.appcountries.view

import com.github.terrakok.cicerone.Screen
import ru.geekbrains.appcountries.model.Country

interface IScreens {
    fun countries(): Screen
    fun country(country: Country): Screen
}