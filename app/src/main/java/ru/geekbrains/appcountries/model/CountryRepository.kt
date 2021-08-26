package ru.geekbrains.appcountries.model

interface CountryRepository {
    fun getCountries(): List<Country>
    fun getCountryByName(name: String): Country?
}