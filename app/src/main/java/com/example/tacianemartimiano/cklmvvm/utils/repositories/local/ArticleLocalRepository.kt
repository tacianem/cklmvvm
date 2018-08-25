package com.example.tacianemartimiano.cklmvvm.utils.repositories.local

import android.app.Application
import android.arch.lifecycle.LiveData
import android.util.Log
import com.example.tacianemartimiano.cklmvvm.models.Article
import com.example.tacianemartimiano.cklmvvm.utils.constants.DATABASE_ERROR
import com.example.tacianemartimiano.cklmvvm.utils.daos.ArticleDao
import com.example.tacianemartimiano.cklmvvm.utils.database.AppDatabase
import kotlinx.coroutines.experimental.launch

class ArticleLocalRepository(application: Application) {

    private val database = AppDatabase.getInstance(application)
    private val articleDao: ArticleDao
    private var articlesList: LiveData<MutableList<Article>>

    init {
        articleDao = database.articleDao()
        articlesList = articleDao.allArticles()
    }

    fun clearTables() {
        launch {
            try {
                database.clearAllTables()
            } catch (e: Exception) {
                Log.e(DATABASE_ERROR, e.message)
            }
        }
    }

    fun insertArticle(article: Article, callback: (art: Article) -> Unit) {
        launch {
            try {
                with(article) {
                    getArticle(author, title, date) {
                        if (it == null) {
                            Article.id += 1
                            articleId = Article.id
                            articleDao.insert(article)
                            callback(article)
                        } else {
                            callback(it)
                        }
                    }
                }
            } catch (e: Exception) {
                Log.e(DATABASE_ERROR, e.message)
            }
        }
    }

    fun getArticleById(articleId: Int, callback: (article: Article?) -> Unit) {
        launch {
            try {
                callback(articleDao.getArticleById(articleId))
            } catch (e: Exception) {
                Log.e(DATABASE_ERROR, e.message)
            }
        }
    }

    private fun getArticle(author: String, title: String, date: String, callback: (article: Article?) -> Unit) {
        launch {
            try {
                callback(articleDao.getArticle(author, title, date))
            } catch (e: Exception) {
                Log.e(DATABASE_ERROR, e.message)
            }
        }
    }

    fun updateArticle(article: Article, callback: () -> Unit) {
        launch {
            try {
                articleDao.update(article)
                callback()
            } catch (e: Exception) {
                Log.e(DATABASE_ERROR, e.message)
            }
        }
    }

}
