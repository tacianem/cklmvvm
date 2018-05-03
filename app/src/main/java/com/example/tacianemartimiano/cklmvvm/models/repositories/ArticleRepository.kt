package com.example.tacianemartimiano.cklmvvm.model.repositories

import android.arch.lifecycle.LiveData
import android.os.AsyncTask
import com.example.tacianemartimiano.cklmvvm.model.dao.ArticleDao
import com.example.tacianemartimiano.cklmvvm.model.entities.Article

class ArticleRepository(private val articleDao: ArticleDao) {

    fun getArticleByTitle(id: Int): LiveData<Article> {
        return articleDao.getArticleById(id)
    }

    fun insertArticles(article: Article) {
        insertAsyncTask(articleDao).execute(article)
    }

    fun updateArticle(article: Article) {
        updateAsyncTask(articleDao).execute(article)
    }

    fun deleteArticle(article: Article) {
        deleteAsyncTask(articleDao).execute(article)
    }

    fun getAllArticles(): LiveData<List<Article>> {
        return articleDao.allArticles
    }

    //insert into database
    private class insertAsyncTask internal constructor(private val articleDao: ArticleDao) : AsyncTask<Article, Void, Void>() {

        override fun doInBackground(vararg params: Article): Void? {
            articleDao.insertArticle(params[0])
            return null
        }
    }

    //Update entity in database
    private class updateAsyncTask internal constructor(private val articleDao: ArticleDao) : AsyncTask<Article, Void, Void>() {

        override fun doInBackground(vararg params: Article): Void? {
            articleDao.updateArticle(params[0])
            return null
        }
    }

    //Delete from database
    private class deleteAsyncTask internal constructor(private val articleDao: ArticleDao) : AsyncTask<Article, Void, Void>() {

        override fun doInBackground(vararg params: Article): Void? {
            articleDao.deleteArticle(params[0])
            return null
        }
    }
}