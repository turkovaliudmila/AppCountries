package ru.geekbrains.appcountries.model.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.geekbrains.appcountries.model.storage.CountriesStorage

@Module
class CountriesStorageModule {

    @Persisted
    @Provides
    fun provideCountriesDatabaseStorage(context: Context): CountriesStorage =
        Room.databaseBuilder(context, CountriesStorage::class.java, "countriesDB.db")
            .build()

    @InMemory
    @Provides
    fun provideCountriesInMemoryDatabaseStorage(context: Context): CountriesStorage =
        Room.inMemoryDatabaseBuilder(context, CountriesStorage::class.java)
            .fallbackToDestructiveMigration()
            .build()
}