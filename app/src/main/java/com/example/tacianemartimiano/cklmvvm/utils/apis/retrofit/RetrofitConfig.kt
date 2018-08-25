package com.example.tacianemartimiano.cklmvvm.utils.apis.retrofit

import com.example.tacianemartimiano.cklmvvm.utils.apis.retrofit.services.ArticleService
import com.example.tacianemartimiano.cklmvvm.utils.constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig {

    private val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()

    fun articleService(): ArticleService = retrofit.create(ArticleService::class.java)
}