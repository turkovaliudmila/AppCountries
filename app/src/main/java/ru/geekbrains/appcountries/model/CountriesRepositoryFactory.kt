package ru.geekbrains.appcountries.model

import ru.geekbrains.appcountries.model.api.CountriesApiFactory
import ru.geekbrains.appcountries.model.cache.CacheCountryDataSourceFactory

object CountriesRepositoryFactory {

    private val repository: ICountriesRepository by lazy {
        CountriesRepositoryImpl(
            CountriesApiFactory.create(),
            CacheCountryDataSourceFactory.create()
        )
    }

    fun create(): ICountriesRepository = repository
}