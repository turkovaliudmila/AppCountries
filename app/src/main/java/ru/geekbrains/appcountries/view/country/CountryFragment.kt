package ru.geekbrains.appcountries.view.country

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.geekbrains.appcountries.databinding.ViewCountryBinding
import ru.geekbrains.appcountries.model.Country
import ru.geekbrains.appcountries.presenter.CountryPresenter

class CountryFragment : MvpAppCompatFragment(), CountryView {

    private val countryInfo: Country? by lazy {
        arguments?.getParcelable(BUNDLE_EXTRA)
    }

    private var vb: ViewCountryBinding? = null

    private val presenter: CountryPresenter by moxyPresenter {
        CountryPresenter(countryInfo)
    }

    companion object {

        const val BUNDLE_EXTRA = "COUNTRY_INFO"

        fun newInstance(countryInfo: Country): Fragment {
            val fragment = CountryFragment()
            fragment.arguments = bundleOf(BUNDLE_EXTRA to countryInfo)
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) =
        ViewCountryBinding.inflate(inflater, container, false).also {
            vb = it
        }.root

    override fun onDestroyView() {
        super.onDestroyView()
        vb = null
    }

    override fun setCountryInfo(countryInfo: Country) {
        vb?.name?.text = countryInfo.name
        vb?.capital?.text = countryInfo.capital
        countryInfo.currencies?.let { currencies -> vb?.currency?.text = currencies.first().name }
    }

}