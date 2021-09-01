package ru.geekbrains.appcountries.scheduler

import dagger.Module
import io.reactivex.Scheduler

@Module
interface ISchedulers {
    fun background(): Scheduler
    fun main(): Scheduler
}