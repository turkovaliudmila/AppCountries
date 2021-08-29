package ru.geekbrains.appcountries.scheduler

import io.reactivex.Scheduler

interface ISchedulers {
    fun background(): Scheduler
    fun main(): Scheduler
}