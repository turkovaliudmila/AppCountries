package ru.geekbrains.appcountries.model.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Update
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface ICountryDao {
    @Query("SELECT * FROM countries")
    fun fetchCountries(): Single<List<RoomCountry>>

    @Query("SELECT * FROM countries WHERE name LIKE :name LIMIT 1")
    fun fetchCountryByName(name: String): Single<RoomCountry>

    @Insert(onConflict = REPLACE)
    fun retain(countries: List<RoomCountry>): Completable

    @Update(onConflict = REPLACE)
    fun retain(country: RoomCountry): Completable
}