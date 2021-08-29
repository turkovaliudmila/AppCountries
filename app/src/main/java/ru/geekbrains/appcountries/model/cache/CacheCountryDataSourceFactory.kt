package ru.geekbrains.appcountries.model.cache

import ru.geekbrains.appcountries.AppCountries
import ru.geekbrains.appcountries.model.storage.CountriesStorageFactory

object CacheCountryDataSourceFactory {
    fun create(): ICacheCountryDataSource =
        CacheCountryDataSourceImpl(
            CountriesStorageFactory.createInMemory(AppCountries.ContextHolder.context)
        )
}