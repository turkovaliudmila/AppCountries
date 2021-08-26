package ru.geekbrains.appcountries.view

import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.geekbrains.appcountries.model.Country
import ru.geekbrains.appcountries.view.countries.CountriesFragment
import ru.geekbrains.appcountries.view.country.CountryFragment

object AppScreens : IScreens {
    override fun countries() = FragmentScreen { CountriesFragment.newInstance() }
    override fun country(country: Country) = FragmentScreen { CountryFragment.newInstance(country) }
}