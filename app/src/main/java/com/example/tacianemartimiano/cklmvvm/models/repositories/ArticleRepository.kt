package com.example.tacianemartimiano.cklmvvm.model.repositories
/*
import android.arch.lifecycle.LiveData
import com.example.tacianemartimiano.cklmvvm.model.dao.ArticleDao
import com.example.tacianemartimiano.cklmvvm.model.entities.Article
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch

class ArticleRepository(private val articleDao: ArticleDao) {

    fun allArticles(): LiveData<List<Article>> {
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

}*/