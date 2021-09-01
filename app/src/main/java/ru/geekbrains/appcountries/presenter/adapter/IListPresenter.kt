package ru.geekbrains.appcountries.presenter.adapter

import ru.geekbrains.appcountries.view.countries.adapter.IItemView

interface IListPresenter<V : IItemView> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}