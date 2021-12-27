package com.example.newsapp

import com.example.newsapp.models.Categories
import java.io.Serializable

class NewsModel (
    var category: Categories,
    var description: String,
    var name: String,
    var url: String
        ) : Serializable
