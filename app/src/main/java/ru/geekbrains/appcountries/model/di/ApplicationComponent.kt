package ru.geekbrains.appcountries.model.di

import android.content.Context
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import ru.geekbrains.appcountries.AppCountries
import ru.geekbrains.appcountries.scheduler.ISchedulers
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, CountriesApiModule::class, CountriesStorageModule::class, CountriesModule::class])
interface ApplicationComponent : AndroidInjector<AppCountries> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun withContext(context: Context): Builder

        @BindsInstance
        fun withRouter(router: Router): Builder

        @BindsInstance
        fun withNavigatorHolder(navigatorHolder: NavigatorHolder): Builder

        @BindsInstance
        fun withSchedulers(schedulers: ISchedulers): Builder

        fun build(): ApplicationComponent

    }

}