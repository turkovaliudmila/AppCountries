package ru.geekbrains.appcountries.scheduler

object SchedulersFactory {
    fun create(): ISchedulers = DefaultSchedulers()
}