package com.example.tacianemartimiano.cklmvvm.utils.apis.retrofit.services

import com.example.tacianemartimiano.cklmvvm.models.Article
import retrofit2.Call
import retrofit2.http.GET

interface ArticleService {

    @GET("challenge/")
    fun fetchApiArticles(): Call<List<Article>>

}