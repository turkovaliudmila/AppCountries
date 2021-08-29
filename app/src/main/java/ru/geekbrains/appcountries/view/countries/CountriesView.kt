package ru.geekbrains.appcountries.view.countries

import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

interface CountriesView : MvpView {
    @SingleState
    fun init()

    @SingleState
    fun updateList()
}