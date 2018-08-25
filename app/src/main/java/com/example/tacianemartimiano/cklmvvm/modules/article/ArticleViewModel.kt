package com.example.tacianemartimiano.cklmvvm.modules.article

import android.app.Activity
import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.content.Intent
import com.example.tacianemartimiano.cklmvvm.models.Article
import com.example.tacianemartimiano.cklmvvm.modules.articledetails.ArticleDetailsActivity
import com.example.tacianemartimiano.cklmvvm.modules.articlesorting.ArticleSortingActivity
import com.example.tacianemartimiano.cklmvvm.utils.apis.retrofit.responses.ArticleResponse
import com.example.tacianemartimiano.cklmvvm.utils.constants.EXTRA_ARTICLE
import com.example.tacianemartimiano.cklmvvm.utils.repositories.api.ArticleApiRepository
import com.example.tacianemartimiano.cklmvvm.utils.repositories.local.ArticleLocalRepository

class ArticleViewModel(application: Application) : AndroidViewModel(application) {

    var articlesLiveData: MutableLiveData<List<Article>> = MutableLiveData()
    private var articleLocalRepository: ArticleLocalRepository = ArticleLocalRepository(application)
    private var articleApiRepository: ArticleApiRepository = ArticleApiRepository()

//    fun clearTables() {
//        articleLocalRepository.clearTables()
//    }

    fun fetchArticles() {
        articleApiRepository.fetchApiArticles(object : ArticleResponse {
            override fun success(articles: List<Article>) {
                addArticles(articles)
            }
        })
    }

    private fun addArticles(articles: List<Article>) {
        var updatedArticles = mutableListOf<Article>()
        articles.forEach { article ->
            articleLocalRepository.insertArticle(article) {
                updatedArticles.add(it)
                articlesLiveData.postValue(updatedArticles) //TODO ESPERAR TODAS TASKS VOLTAREM PRA UPDATAR
            }
        }
    }

    fun onArticleClicked(context: Context, article: Article) {
        val detailsIntent = Intent(context, ArticleDetailsActivity::class.java)
        article.read = true
        articleLocalRepository.updateArticle(article) {
            detailsIntent.putExtra(EXTRA_ARTICLE, article.articleId)
            context.startActivity(detailsIntent)
        }
    }

    fun onSortClicked(context: Context) {
        val sortIntent = Intent(context, ArticleSortingActivity::class.java)
        (context as Activity).startActivityForResult(sortIntent, 0)
    }

}
