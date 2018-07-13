package com.example.tacianemartimiano.cklmvvm.utils.repositories.api

import com.example.tacianemartimiano.cklmvvm.models.Article
import io.reactivex.Observable
import retrofit2.http.GET

interface ArticleApi {

    @GET("challenge/")
    fun fetchArticles(): Observable<MutableList<Article>>

}