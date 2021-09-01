package ru.geekbrains.appcountries.model.storage

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "countries")
data class RoomCountry(
    @PrimaryKey @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "capital") var capital: String,
    @ColumnInfo(name = "flag") var flag: String?,
    @ColumnInfo(name = "region") var region: String?,
    @ColumnInfo(name = "population") var population: Int?
)
