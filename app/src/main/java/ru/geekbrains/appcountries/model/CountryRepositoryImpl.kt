package ru.geekbrains.appcountries.model

class CountryRepositoryImpl : CountryRepository {
    private val countries = listOf(
        Country("Russia", "Moscow", "Ruble"),
        Country("USA", "Washington", "Dollar"),
        Country("Canada", "Ottawa", "dollar")
    )

    override fun getCountries() = countries

    override fun getCountryByName(name: String): Country? =
        countries.firstOrNull { country -> country.name == name }
}