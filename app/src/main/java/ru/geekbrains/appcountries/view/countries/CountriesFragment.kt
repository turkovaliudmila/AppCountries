package ru.geekbrains.appcountries.view.countries

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.reactivex.android.schedulers.AndroidSchedulers
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.geekbrains.appcountries.AppCountries.Navigation.router
import ru.geekbrains.appcountries.databinding.ViewCountriesBinding
import ru.geekbrains.appcountries.model.CountriesRepositoryFactory
import ru.geekbrains.appcountries.presenter.CountriesPresenter
import ru.geekbrains.appcountries.scheduler.SchedulersFactory
import ru.geekbrains.appcountries.view.countries.adapter.CountriesAdapter

class CountriesFragment : MvpAppCompatFragment(), CountriesView {
    companion object {
        fun newInstance(): Fragment =
            CountriesFragment()
    }

    private val presenter: CountriesPresenter by moxyPresenter {
        CountriesPresenter(CountriesRepositoryFactory.create(), router = router, AndroidSchedulers.mainThread())
    }

    var adapter: CountriesAdapter? = null

    private var vb: ViewCountriesBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) =
        ViewCountriesBinding.inflate(inflater, container, false).also {
            vb = it
        }.root

    override fun onDestroyView() {
        super.onDestroyView()
        vb = null
    }

    override fun init() {
        adapter = CountriesAdapter(presenter.countriesListPresenter)
        vb?.countries?.adapter = adapter
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }
}
