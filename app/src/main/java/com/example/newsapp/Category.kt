package com.example.newsapp

import com.example.newsapp.models.Categories
import java.io.Serializable

data class Category(
    var category: Categories,
    var name: Int,
    var news: List<NewsModel>
) : Serializable
