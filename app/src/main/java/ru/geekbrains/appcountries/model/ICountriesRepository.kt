package ru.geekbrains.appcountries.model

import io.reactivex.Observable

interface ICountriesRepository {
    fun getCountries(): Observable<List<Country>>
}