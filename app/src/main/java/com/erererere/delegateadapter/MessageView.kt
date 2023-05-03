package com.erererere.delegateadapter

import com.erererere.delegateadapter.adapter.ViewBindingDelegateAdapter
import com.erererere.delegateadapter.databinding.ViewMessageBinding

class MessageView(val click: (() -> Unit)? = null) :
    ViewBindingDelegateAdapter<MessageItem, ViewMessageBinding>(ViewMessageBinding::inflate) {

    override fun ViewMessageBinding.onBind(item: MessageItem) {
        message.text = item.message
    }

    override fun isForViewType(item: Any): Boolean {
        return item is MessageItem
    }

    override fun MessageItem.getItemId(): Any {
        return message.hashCode()
    }
}