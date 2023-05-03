package com.erererere.delegateadapter.slides

import androidx.recyclerview.widget.RecyclerView
import com.erererere.delegateadapter.databinding.ItemSlidesBinding

class SlidesViewHolder(
    private val view: ItemSlidesBinding,
) : RecyclerView.ViewHolder(view.root) {

    fun bind(item: String) {
        view.message.text = item
    }
}