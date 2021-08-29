package ru.geekbrains.appcountries.model.datasource

import ru.geekbrains.appcountries.model.api.CountriesApiFactory

object CountryDataSourceFactory {
    fun create(): ICountryDataSource = CountryDataSource(CountriesApiFactory.create())
}