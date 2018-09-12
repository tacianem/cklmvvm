package com.example.tacianemartimiano.cklmvvm.modules.articledetails

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.example.tacianemartimiano.cklmvvm.models.Article
import com.example.tacianemartimiano.cklmvvm.modules.article.ArticleActivity
import com.example.tacianemartimiano.cklmvvm.utils.constants.ARTICLE_DETAILS_ERROR
import com.example.tacianemartimiano.cklmvvm.utils.constants.EXTRA_ARTICLE
import com.example.tacianemartimiano.cklmvvm.utils.repositories.local.ArticleLocalRepository
import kotlinx.coroutines.experimental.launch

class ArticleDetailsViewModel(application: Application) : AndroidViewModel(application) {

    var articleLiveData: MutableLiveData<Article> = MutableLiveData()
    private var articlesRepository: ArticleLocalRepository = ArticleLocalRepository(application)

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

    fun onBackPressed(context: Context) {
        //To mark as read properly we call onCreate on ArticleActivity
        context.startActivity(Intent(context, ArticleActivity::class.java))
    }
}