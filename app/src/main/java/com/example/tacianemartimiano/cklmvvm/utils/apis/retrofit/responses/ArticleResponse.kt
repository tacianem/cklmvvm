package com.example.tacianemartimiano.cklmvvm.utils.apis.retrofit.responses

import com.example.tacianemartimiano.cklmvvm.models.Article

interface ArticleResponse {

    fun success(articles: List<Article>)

}