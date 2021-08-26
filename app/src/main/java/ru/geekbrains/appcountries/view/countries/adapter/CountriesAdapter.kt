package ru.geekbrains.appcountries.view.countries.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.appcountries.databinding.ItemCountryBinding
import ru.geekbrains.appcountries.presenter.adapter.ICountriesListPresenter

class CountriesAdapter(private val presenter: ICountriesListPresenter) :
    RecyclerView.Adapter<CountriesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            ItemCountryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        ).apply {
            itemView.setOnClickListener { presenter.itemClickListener?.invoke(this) }
        }

    override fun getItemCount() = presenter.getCount()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        presenter.bindView(holder.apply { pos = position })

    inner class ViewHolder(private val vb: ItemCountryBinding) : RecyclerView.ViewHolder(vb.root),
        CountryItemView {
        override var pos = -1

        override fun setName(name: String) = with(vb) {
            countryName.text = name
        }
    }
}