package com.example.tacianemartimiano.cklmvvm.modules.article_details

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.os.Bundle
import com.example.tacianemartimiano.cklmvvm.models.Article
import com.example.tacianemartimiano.cklmvvm.utils.constants.EXTRA_ARTICLE
import com.example.tacianemartimiano.cklmvvm.utils.repositories.ArticleRepository

class ArticleDetailsViewModel(application: Application): AndroidViewModel(application) {

    var article = MutableLiveData<Article>()
    private var articlesRepository: ArticleRepository = ArticleRepository(getApplication())

    fun initWithExtras(extras: Bundle?) {
        val articleId = extras?.getLong(EXTRA_ARTICLE)
    }

}