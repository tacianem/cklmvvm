package com.example.tacianemartimiano.cklmvvm.utils.api

import com.example.tacianemartimiano.cklmvvm.model.entities.Article
import rx.Observable

object ArticlesApiRespositoy {

    fun fetchArticles(): Observable<List<Article>>? {
        val retrofit = RetrofitHelper.retrofit
        val articlesInterface = retrofit?.create(ArticlesApi::class.java)
        return articlesInterface?.fetchArticles()
    }
}