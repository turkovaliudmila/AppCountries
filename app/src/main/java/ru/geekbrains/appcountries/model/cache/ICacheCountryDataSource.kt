package ru.geekbrains.appcountries.model.cache

import io.reactivex.Single
import ru.geekbrains.appcountries.model.storage.RoomCountry

interface ICacheCountryDataSource {
    fun retain(countries: List<RoomCountry>): Single<List<RoomCountry>>
    fun getCountries(): Single<List<RoomCountry>>
}