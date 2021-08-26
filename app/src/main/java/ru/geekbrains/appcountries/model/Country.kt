package ru.geekbrains.appcountries.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Country(
    val name: String,
    val capital: String,
    val currency: String
) : Parcelable