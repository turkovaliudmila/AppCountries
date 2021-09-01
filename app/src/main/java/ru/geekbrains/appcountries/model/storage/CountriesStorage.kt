package ru.geekbrains.appcountries.model.storage

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(exportSchema = false, entities = [RoomCountry::class], version = 3)
abstract class CountriesStorage : RoomDatabase() {
    abstract fun countriesDao(): ICountryDao
}