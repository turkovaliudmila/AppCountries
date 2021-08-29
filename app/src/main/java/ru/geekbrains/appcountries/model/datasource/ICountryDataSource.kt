package ru.geekbrains.appcountries.model.datasource

import io.reactivex.Single
import ru.geekbrains.appcountries.model.Country

interface ICountryDataSource {
    fun getCountries(): Single<List<Country>>
}