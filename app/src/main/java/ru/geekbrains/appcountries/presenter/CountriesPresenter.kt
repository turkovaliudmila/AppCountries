package ru.geekbrains.appcountries.presenter

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.geekbrains.appcountries.model.Country
import ru.geekbrains.appcountries.model.CountryRepository
import ru.geekbrains.appcountries.presenter.adapter.ICountriesListPresenter
import ru.geekbrains.appcountries.view.AppScreens
import ru.geekbrains.appcountries.view.countries.CountriesView
import ru.geekbrains.appcountries.view.countries.adapter.CountryItemView

class CountriesPresenter(
    private val countryRepository: CountryRepository,
    private val router: Router
) : MvpPresenter<CountriesView>() {
    class CountriesListPresenter : ICountriesListPresenter {
        val countries = mutableListOf<Country>()

        override var itemClickListener: ((CountryItemView) -> Unit)? = null

        override fun getCount() = countries.size

        override fun bindView(view: CountryItemView) {
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
        val countries = countryRepository.getCountries()
        countriesListPresenter.countries.addAll(countries)
        viewState.updateList()
    }
}