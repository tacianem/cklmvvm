package com.example.tacianemartimiano.cklmvvm.utils.repositories

import android.app.Application
import android.arch.lifecycle.LiveData
import android.util.Log
import com.example.tacianemartimiano.cklmvvm.model.dao.ArticleDao
import com.example.tacianemartimiano.cklmvvm.models.Article
import com.example.tacianemartimiano.cklmvvm.utils.daos.ArticleTagDao
import com.example.tacianemartimiano.cklmvvm.utils.daos.TagDao
import com.example.tacianemartimiano.cklmvvm.utils.database.AppDatabase
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch

class ArticleRepository(application: Application) {

    private val articleDao: ArticleDao
    private val articleTagDao: ArticleTagDao
    private val tagDao: TagDao
    private var articlesList: LiveData<MutableList<Article>>

    init {
        val database = AppDatabase.getInstance(application)
        articleDao = database?.articleDao()
        articleTagDao = database?.articleTagDao()
        tagDao = database?.tagDao()
        articlesList = articleDao?.allArticles()
    }

    fun insertArticle(article: Article, onSuccess: (() -> Unit)? = null) {
        launch {
            async {
                try {
                    articleDao?.insert(article)
                    for (tag in article.tags) {
                        tagDao.insert(tag)
                        val articleTag = Article.ArticleTag()
                        articleTag.artId = article.articleId
                        articleTag.artTagId = tag.tagId
                        Log.d("Art ID from repository", articleTag.artId.toString())
                        Log.d("Tag ID from repository", articleTag.artTagId.toString())
                        articleTagDao.insert(articleTag)
                    }
                } catch (e: Exception) {
                    //Log.e("ERROR", getString(R.string.database_error)) TODO: NEEDS CONTEXT?
                    return@async
                }
                onSuccess?.invoke()
            }
        }
    }
}