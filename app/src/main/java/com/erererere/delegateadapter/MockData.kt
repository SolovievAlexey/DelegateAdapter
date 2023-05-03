package com.erererere.delegateadapter

object MockData {

    fun get(): MutableList<Any> {
        val list = mutableListOf<Any>()
        repeat(100) {
            list.add(
                MessageItem(
                    message = "Тестовое сообщение которое увидит пользователь - $it"
                )
            )
        }

        list.add(0, HeaderItem(header = "Это заголовок для ленты новостей"))

        list.add(12, HeaderItem(header = "А это еще один заголовок для ленты новостей"))

        list.add(26, HeaderItem(header = "А это еще один заголовок для ленты новостей"))

       val slides =  SlideItem(
            message = listOf(
                "Тут будет располагаться какой-то текст",
                "А тут еще будет какой-то текст",
                "Ну та тут еще будет текст",
                "Тут будет располагаться какой-то текст",
                "А тут еще будет какой-то текст",
                "Ну та тут еще будет текст",
                "Тут будет располагаться какой-то текст",
                "А тут еще будет какой-то текст",
                "Ну та тут еще будет текст",
            )
        )
        list.add(5, slides)


        return list
    }
}