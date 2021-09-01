package ru.geekbrains.appcountries.model.di

import javax.inject.Qualifier

@Qualifier
annotation class InMemory

@Qualifier
annotation class Persisted