package ru.geekbrains.appcountries.model.cache

import io.reactivex.Single
import ru.geekbrains.appcountries.model.di.InMemory
import ru.geekbrains.appcountries.model.storage.CountriesStorage
import ru.geekbrains.appcountries.model.storage.RoomCountry
import javax.inject.Inject

class CacheCountryDataSourceImpl @Inject constructor(@InMemory private val countriesStorage: CountriesStorage) :
    ICacheCountryDataSource {

    override fun retain(countries: List<RoomCountry>): Single<List<RoomCountry>> =
        countriesStorage.countriesDao().retain(countries).andThen(getCountries())

    override fun getCountries(): Single<List<RoomCountry>> =
        countriesStorage.countriesDao().fetchCountries()
}