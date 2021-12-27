package com.example.newsapp.models

import com.example.newsapp.Category
import com.example.newsapp.NewsModel
import com.example.newsapp.R

class DataBase {
    companion object {

        val categories = arrayListOf<Category>(
            Category(Categories.Politics, R.string.politics, getNewsByCategories(Categories.Politics)),
            Category(Categories.Finance, R.string.finance, getNewsByCategories(Categories.Finance)),
            Category(Categories.Education, R.string.education, getNewsByCategories(Categories.Education)),
            Category(Categories.Health, R.string.health, getNewsByCategories(Categories.Health))
        )


        val news = arrayListOf(
            NewsModel(Categories.Politics, "Описание", "Название", "url"),
            NewsModel(Categories.Politics, "Описание", "Название", "url"),
            NewsModel(Categories.Politics, "Описание", "Название", "url"),

            NewsModel(Categories.Finance, "Описание", "Название", "url"),
            NewsModel(Categories.Finance, "Описание", "Название", "url"),
            NewsModel(Categories.Finance, "Описание", "Название", "url"),

            NewsModel(Categories.Education, "Описание", "Название", "url"),
            NewsModel(Categories.Education, "Описание", "Название", "url"),
            NewsModel(Categories.Education, "Описание", "Название", "url"),

            NewsModel(Categories.Health, "Описание", "Название", "url"),
            NewsModel(Categories.Health, "Описание", "Название", "url"),
            NewsModel(Categories.Health, "Описание", "Название", "url"),


            )
        private fun getNewsByCategories(categories: Categories): List<NewsModel> =
            news.filter { it.category == categories }
    }
}

enum class Categories(value: Int) {
    Politics(1),
    Finance(2),
    Education(3),
    Health(4)

}
