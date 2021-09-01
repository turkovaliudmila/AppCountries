package ru.geekbrains.appcountries.presenter

import moxy.MvpPresenter
import ru.geekbrains.appcountries.model.Country
import ru.geekbrains.appcountries.view.country.CountryView

class CountryPresenter(private val countryInfo: Country?) : MvpPresenter<CountryView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        countryInfo?.let(viewState::setCountryInfo)
    }
}