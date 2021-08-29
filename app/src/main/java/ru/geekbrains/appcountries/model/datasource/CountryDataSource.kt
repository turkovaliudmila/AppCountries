package ru.geekbrains.appcountries.model.datasource

import io.reactivex.Single
import ru.geekbrains.appcountries.model.Country
import ru.geekbrains.appcountries.model.api.ICountriesApi

class CountryDataSource(private val countriesApi: ICountriesApi) : ICountryDataSource {
    override fun getCountries(): Single<List<Country>> = countriesApi.getCountries()
}