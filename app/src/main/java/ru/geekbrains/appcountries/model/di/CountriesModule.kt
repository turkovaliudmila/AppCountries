package ru.geekbrains.appcountries.model.di

import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.geekbrains.appcountries.model.CountriesRepositoryImpl
import ru.geekbrains.appcountries.model.ICountriesRepository
import ru.geekbrains.appcountries.model.cache.CacheCountryDataSourceImpl
import ru.geekbrains.appcountries.model.cache.ICacheCountryDataSource
import ru.geekbrains.appcountries.model.datasource.CountryDataSource
import ru.geekbrains.appcountries.model.datasource.ICountryDataSource
import ru.geekbrains.appcountries.view.MainActivity
import ru.geekbrains.appcountries.view.countries.CountriesFragment
import ru.geekbrains.appcountries.view.country.CountryFragment
import javax.inject.Singleton

@Module
interface CountriesModule {

    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    fun bindCountriesFragment(): CountriesFragment

    @ContributesAndroidInjector
    fun bindCountryFragment(): CountryFragment

    @Singleton
    @Binds
    fun bindCountriesRepository(repository: CountriesRepositoryImpl): ICountriesRepository

    @Singleton
    @Binds
    fun bindCountryDataSource(dataSource: CountryDataSource): ICountryDataSource

    @Singleton
    @Binds
    fun bindCacheCountryDataSource(dataSource: CacheCountryDataSourceImpl): ICacheCountryDataSource

}