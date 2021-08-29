package ru.geekbrains.appcountries.presenter

import com.github.terrakok.cicerone.Router
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import moxy.MvpPresenter
import ru.geekbrains.appcountries.model.Country
import ru.geekbrains.appcountries.model.ICountriesRepository
import ru.geekbrains.appcountries.presenter.adapter.ICountriesListPresenter
import ru.geekbrains.appcountries.view.AppScreens
import ru.geekbrains.appcountries.view.countries.CountriesView
import ru.geekbrains.appcountries.view.countries.adapter.ICountryItemView

class CountriesPresenter(
    private val countryRepository: ICountriesRepository,
    private val router: Router,
    private val uiSheduler: Scheduler
) : MvpPresenter<CountriesView>() {

    private val disposables = CompositeDisposable()

    class CountriesListPresenter : ICountriesListPresenter {
        val countries = mutableListOf<Country>()

        override var itemClickListener: ((ICountryItemView) -> Unit)? = null

        override fun getCount() = countries.size

        override fun bindView(view: ICountryItemView) {
            val country = countries[view.pos]
            view.setName(country.name)
        }
    }

    val countriesListPresenter = CountriesListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()

        countriesListPresenter.itemClickListener = { itemView ->
            val countryInfo = countriesListPresenter.countries[itemView.pos]
            router.navigateTo(AppScreens.country(countryInfo))
        }
    }

    private fun loadData() {
        disposables +=
            countryRepository
                .getCountries()
                .observeOn(uiSheduler)
                .subscribe({ countries ->
                    countriesListPresenter.countries.clear()
                    countriesListPresenter.countries.addAll(countries)
                    viewState.updateList()
                }, {})
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.dispose()
    }
}