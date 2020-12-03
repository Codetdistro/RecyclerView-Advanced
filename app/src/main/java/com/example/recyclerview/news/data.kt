package com.example.recyclerview.news

data class data(
    val articles: ArrayList<Article>,
    val status: String,
    val totalResults: Int
)