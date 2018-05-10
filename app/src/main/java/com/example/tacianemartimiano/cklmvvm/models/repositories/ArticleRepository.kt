package com.example.tacianemartimiano.cklmvvm.model.repositories

import android.arch.lifecycle.LiveData
import com.example.tacianemartimiano.cklmvvm.model.dao.ArticleDao
import com.example.tacianemartimiano.cklmvvm.model.entities.Article
import com.example.tacianemartimiano.cklmvvm.models.entities.ArticleTag
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch

class ArticleRepository(private val articleDao: ArticleDao) {

    fun syncArticles() {
        launch {
            async {
                fetchArticlesFromAPI() //TODO IF THEY ARE NOT ALREADY IN ROOM!!!
            }
        }
    }

    //Api
    private fun fetchArticlesFromAPI(){
//        val api = RetrofitHelper.getRetrofit(true)?.create(CKLArticlesService::class.java)
//        api?.getArticles()?.execute()?.body()?.let { articles ->
//            articles.forEach {
//                insertArticleInDatabase(it)
//            }
//        }
    }

    //Database
    fun allArticles(): LiveData<List<ArticleTag>> {
        return articleDao.allArticles()
    }

    fun getArticleByIDFromDatabase(id: Long, onSuccess: (Article?) -> Unit, onFailure: (String) -> Unit) {
        launch {
            async {
                val article = articleDao.getArticleByID(id)
                onSuccess(article)
            }
        }
    }
    
    private fun insertArticleInDatabase(article: Article): Boolean {
        try {
            articleDao.insertArticle(article)
        } catch (e: Exception) {
            println(e.message)
            return false
        }
        return true
    }

    fun insertArticles(articles: List<Article>){ //TODO MOCK, REMOVE
        articles.forEach {
            insertArticleInDatabase(it)
        }
    }
}

