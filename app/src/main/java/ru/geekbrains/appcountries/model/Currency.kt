package ru.geekbrains.appcountries.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Currency(
    @Expose @SerializedName("name") val name: String
) : Parcelable
