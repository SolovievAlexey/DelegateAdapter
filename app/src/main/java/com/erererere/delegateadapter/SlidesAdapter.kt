package com.erererere.delegateadapter

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.erererere.delegateadapter.adapter.ViewBindingDelegateAdapter
import com.erererere.delegateadapter.databinding.ViewSlideBinding
import com.erererere.delegateadapter.slides.SlidesViewAdapter

class SlidesAdapter :
    ViewBindingDelegateAdapter<SlideItem, ViewSlideBinding>(ViewSlideBinding::inflate) {

    private val adapter = SlidesViewAdapter()

    override fun ViewSlideBinding.onBind(item: SlideItem) {
        slidesRecyclerView.layoutManager =
            LinearLayoutManager(slidesRecyclerView.context, RecyclerView.HORIZONTAL, false)
        slidesRecyclerView.adapter = adapter
        adapter.submitList(item.message)
    }

    override fun isForViewType(item: Any): Boolean {
        return item is SlideItem
    }

    override fun SlideItem.getItemId(): Any {
        return this.hashCode()
    }
}