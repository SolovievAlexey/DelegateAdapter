package com.erererere.delegateadapter.adapter

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

open class MultiTypeAdapter private constructor(adapters: List<DelegateAdapter>) :
    RecyclerView.Adapter<ViewHolder>() {

    private val adapterState = AdaptersState(adapters = adapters.toList())

    override fun getItemViewType(itemPosition: Int): Int =
        adapterState.getViewType(itemPosition)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return adapterState.getAdapter(viewType).onCreateViewHolder(parent, viewType)
    }

    override fun getItemCount(): Int {
        return adapterState.data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        adapterState.getAdapter(getItemViewType(position))
            .onBindViewHolder(holder, adapterState.data, position)
    }

    override fun onViewRecycled(holder: ViewHolder) =
        adapterState.getAdapter(holder.itemViewType).onRecycled(holder)

    override fun onViewAttachedToWindow(holder: ViewHolder) {
        adapterState.getAdapter(holder.itemViewType).onAttachedToWindow(holder)
    }

    override fun onViewDetachedFromWindow(holder: ViewHolder) {
        adapterState.getAdapter(holder.itemViewType).onDetachedFromWindow(holder)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(newData: List<Any>) {
        adapterState.data.clear()
        adapterState.data.addAll(newData)
        notifyDataSetChanged()
    }

    class Builder : MultiTypeAdapter(emptyList()) {

        private val adapters = mutableListOf<DelegateAdapter>()

        fun adapter(adapter: () -> DelegateAdapter): Builder {
            adapters.add(adapter.invoke())
            return this
        }

        fun build(): MultiTypeAdapter {
            return MultiTypeAdapter(adapters)
        }
    }
}
