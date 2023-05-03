package com.erererere.delegateadapter

import com.erererere.delegateadapter.adapter.ViewBindingDelegateAdapter
import com.erererere.delegateadapter.databinding.ViewHeaderBinding

class HeaderView(val click: () -> Unit) :
    ViewBindingDelegateAdapter<HeaderItem, ViewHeaderBinding>(ViewHeaderBinding::inflate) {

    override fun ViewHeaderBinding.onBind(item: HeaderItem) {
        header.text = item.header
        container.setOnClickListener {
            click.invoke()
        }
    }

    override fun isForViewType(item: Any): Boolean {
        return item is HeaderItem
    }

    override fun HeaderItem.getItemId(): Any {
        return this.hashCode()
    }
}