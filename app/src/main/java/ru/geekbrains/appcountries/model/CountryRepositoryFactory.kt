package ru.geekbrains.appcountries.model

object CountryRepositoryFactory {
    fun create(): CountryRepository = CountryRepositoryImpl()
}