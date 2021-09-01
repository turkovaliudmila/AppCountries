package ru.geekbrains.appcountries.view.countries

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.terrakok.cicerone.Router
import moxy.ktx.moxyPresenter
import ru.geekbrains.appcountries.databinding.ViewCountriesBinding
import ru.geekbrains.appcountries.model.ICountriesRepository
import ru.geekbrains.appcountries.presenter.CountriesPresenter
import ru.geekbrains.appcountries.presenter.abs.AbsFragment
import ru.geekbrains.appcountries.scheduler.ISchedulers
import ru.geekbrains.appcountries.view.countries.adapter.CountriesAdapter
import javax.inject.Inject

class CountriesFragment : AbsFragment(), CountriesView {
    companion object {
        fun newInstance(): Fragment =
            CountriesFragment()
    }

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var schedulers: ISchedulers

    @Inject
    lateinit var countriesRepository: ICountriesRepository

    private val presenter: CountriesPresenter by moxyPresenter {
        CountriesPresenter(countriesRepository, router = router, schedulers)
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
