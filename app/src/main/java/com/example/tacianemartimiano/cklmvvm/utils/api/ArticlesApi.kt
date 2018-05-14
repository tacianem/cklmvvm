package com.example.tacianemartimiano.cklmvvm.utils.api

import com.example.tacianemartimiano.cklmvvm.model.entities.Article
import retrofit2.http.GET
import rx.Observable

interface ArticlesApi {

    @GET("/challenge/")
    fun fetchArticles(): Observable<List<Article>>
}