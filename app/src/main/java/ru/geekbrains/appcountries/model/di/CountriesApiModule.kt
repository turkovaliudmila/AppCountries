package ru.geekbrains.appcountries.model.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.geekbrains.appcountries.model.api.ApiInterceptor
import ru.geekbrains.appcountries.model.api.ICountriesApi
import javax.inject.Singleton

@Module
class CountriesApiModule {

    @Singleton
    @Provides
    fun provideGitHubApi(): ICountriesApi =
        Retrofit.Builder()
            .baseUrl("https://restcountries.eu/")
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(ApiInterceptor)
                    .addInterceptor(HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    })
                    .build()
            )
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ICountriesApi::class.java)

    private val gson: Gson =
        GsonBuilder()
            .create()

}