package ru.geekbrains.appcountries.model

import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import ru.geekbrains.appcountries.model.api.ICountriesApi
import ru.geekbrains.appcountries.model.cache.ICacheCountryDataSource
import javax.inject.Inject

data class CountriesRepositoryImpl @Inject constructor(
    private val api: ICountriesApi,
    private val cache: ICacheCountryDataSource
) : ICountriesRepository {

    override fun getCountries() =
        Observable.merge(
            cache.getCountries().flatMap { countries ->
                Single.fromCallable {
                    val listCountries = countries.map { country ->
                        Country(
                            country.name,
                            country.capital,
                            country.flag,
                            country.region,
                            country.population,
                            null
                        )
                    }
                    listCountries
                }
            }.toObservable(),
            api.getCountries().toObservable()
        )
            .subscribeOn(Schedulers.io())

}