package ru.geekbrains.appcountries.view.country

import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState
import ru.geekbrains.appcountries.model.Country

interface CountryView : MvpView {
    @SingleState
    fun setCountryInfo(countryInfo: Country)
}