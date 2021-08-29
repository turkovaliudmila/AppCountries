package ru.geekbrains.appcountries.model.storage

import android.content.Context
import androidx.room.Room

object CountriesStorageFactory {
    fun create(context: Context): CountriesStorage =
        Room.databaseBuilder(context, CountriesStorage::class.java, "countriesDB.db")
            .build()

    fun createInMemory(context: Context): CountriesStorage =
        Room.inMemoryDatabaseBuilder(context, CountriesStorage::class.java)
            .fallbackToDestructiveMigration()
            .build()
}