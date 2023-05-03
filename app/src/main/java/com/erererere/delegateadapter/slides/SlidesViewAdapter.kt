package com.erererere.delegateadapter.slides

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.erererere.delegateadapter.databinding.ItemSlidesBinding

class SlidesViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            ItemSlidesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return SlidesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as SlidesViewHolder).bind(items[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(newModel: List<String>) {
        items.clear()
        items.addAll(newModel)
        notifyDataSetChanged()
    }
}
