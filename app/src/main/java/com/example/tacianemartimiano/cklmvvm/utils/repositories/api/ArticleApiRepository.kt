package com.example.tacianemartimiano.cklmvvm.utils.repositories.api

import android.util.Log
import com.example.tacianemartimiano.cklmvvm.models.Article
import com.example.tacianemartimiano.cklmvvm.utils.apis.retrofit.RetrofitConfig
import com.example.tacianemartimiano.cklmvvm.utils.apis.retrofit.responses.ArticleResponse
import com.example.tacianemartimiano.cklmvvm.utils.constants.RETROFIT_ERROR
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArticleApiRepository {

    fun fetchApiArticles(articleResponse: ArticleResponse) {
        val call = RetrofitConfig().articleService().fetchApiArticles()
        call.enqueue(object : Callback<List<Article>?> {
            override fun onResponse(call: Call<List<Article>?>?,
                                    response: Response<List<Article>?>?) {
                response?.body()?.let {
                    articleResponse.success(it)
                }
            }

            override fun onFailure(call: Call<List<Article>?>?,
                                   throwable: Throwable?) {
                Log.e(RETROFIT_ERROR, throwable?.message)
            }
        })
    }
}