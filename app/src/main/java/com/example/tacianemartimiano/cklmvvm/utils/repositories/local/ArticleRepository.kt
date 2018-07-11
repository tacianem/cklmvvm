package com.example.tacianemartimiano.cklmvvm.utils.repositories.local

import android.app.Application
import android.arch.lifecycle.LiveData
import android.util.Log
import com.example.tacianemartimiano.cklmvvm.model.dao.ArticleDao
import com.example.tacianemartimiano.cklmvvm.models.Article
import com.example.tacianemartimiano.cklmvvm.utils.constants.ERROR_DATABASE
import com.example.tacianemartimiano.cklmvvm.utils.database.AppDatabase
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch

class ArticleRepository(application: Application) {

    private val articleDao: ArticleDao
    private var articlesList: LiveData<MutableList<Article>>

    init {
        val database = AppDatabase.getInstance(application)
        articleDao = database.articleDao()
        articlesList = articleDao.allArticles()
    }

    fun insertArticle(article: Article) {
        launch {
            async {
                try {
                    val currentArticle: Article? = articleDao.articleByID(article.articleId)
                    if (currentArticle == null) { //TODO ANNOTATION IN BD AND REMOVE IF ?!
                        articleDao.insert(article)
                    }
                } catch (e: Exception) {
                    Log.e(ERROR_DATABASE, e.message)
                    return@async
                }
            }
        }
    }

    fun getArticle(articleId: Int?): Article {
        return articleDao.articleByID(articleId)
    }

}