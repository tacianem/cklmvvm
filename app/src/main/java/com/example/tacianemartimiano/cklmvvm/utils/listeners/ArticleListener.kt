package com.example.tacianemartimiano.cklmvvm.utils.listeners

import com.example.tacianemartimiano.cklmvvm.model.entities.Article

interface ArticleListener {
    fun onArticleClicked(article: Article?)
}