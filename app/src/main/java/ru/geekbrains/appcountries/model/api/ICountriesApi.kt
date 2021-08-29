package ru.geekbrains.appcountries.model.api

import io.reactivex.Single
import retrofit2.http.GET
import ru.geekbrains.appcountries.model.Country

interface ICountriesApi {
    @GET("/rest/v2/all")
    fun getCountries(): Single<List<Country>>
}