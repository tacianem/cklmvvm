package com.example.tacianemartimiano.cklmvvm.modules.articledetails

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.os.Bundle
import android.util.Log
import com.example.tacianemartimiano.cklmvvm.models.Article
import com.example.tacianemartimiano.cklmvvm.utils.constants.ARTICLE_DETAILS_ERROR
import com.example.tacianemartimiano.cklmvvm.utils.constants.EXTRA_ARTICLE
import com.example.tacianemartimiano.cklmvvm.utils.repositories.local.ArticleRepository
import kotlinx.coroutines.experimental.launch

class ArticleDetailsViewModel(application: Application) : AndroidViewModel(application) {

    var articleLiveData: MutableLiveData<Article> = MutableLiveData()
    private var articlesRepository: ArticleRepository = ArticleRepository(application)

    fun initWithExtras(extras: Bundle?) {
        getArticle(extras?.getInt(EXTRA_ARTICLE))
    }

    private fun getArticle(articleId: Int?) {
        launch {
            try {
                articleId?.let { id ->
                    articlesRepository.getArticleById(id) {
                        articleLiveData.postValue(it)
                    }
                }
            } catch (e: Exception) {
                Log.e(ARTICLE_DETAILS_ERROR, e.message)
            }
        }
    }

}