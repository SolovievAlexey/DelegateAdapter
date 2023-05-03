package com.erererere.delegateadapter.adapter

data class AdaptersState(
    private val adapters: List<DelegateAdapter>,
    val data: ArrayList<Any> = ArrayList(),
) {

    fun getViewType(position: Int): Int {
        return adapters.indexOfFirst { it.isForViewType(data, position) }
    }

    fun getAdapter(adapterPosition: Int): DelegateAdapter = adapters[adapterPosition]

    fun getAdapterByItemPosition(itemPosition: Int): DelegateAdapter =
        adapters[getViewType(itemPosition)]
}