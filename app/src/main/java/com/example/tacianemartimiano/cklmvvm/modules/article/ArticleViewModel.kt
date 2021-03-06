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

    var articlesLiveData: MutableLiveData<MutableList<Article>> = MutableLiveData()
    private var articleLocalRepository: ArticleLocalRepository = ArticleLocalRepository(application)
    private var articleApiRepository: ArticleApiRepository = ArticleApiRepository()

    private var allArticles = mutableListOf<Article>()

//    fun clearTables() {
//        articleLocalRepository.clearTables()
//    }

    fun fetchArticles() {
        if (allArticles.isEmpty()) {
            articleApiRepository.fetchApiArticles(object : ArticleResponse {
                override fun success(articles: List<Article>) {
                    addArticles(articles)
                }
            })
        } else { //TODO VER SE TEM NOVOS ARTIGOS PARA DAR FETCH, ETC...
            articlesLiveData.value = allArticles
        }
    }

    private fun addArticles(articles: List<Article>) {
        var updatedArticles = mutableListOf<Article>()
        articles.forEach { article ->
            articleLocalRepository.insertArticle(article) {
                updatedArticles.add(it)
//                articlesLiveData.postValue(updatedArticles)
            }
        }
        Thread.sleep(1000) //waits so the articles are inserted on db
        articlesLiveData.value = updatedArticles
        updatedArticles?.let {
            allArticles = it
        }
    }

    fun onArticleClicked(context: Context, article: Article) {
        val detailsIntent = Intent(context, ArticleDetailsActivity::class.java)
        article.read = true
        for (art in allArticles) {
            if (art.author == article.author && art.title == article.title &&
                    art.date == article.date) {
                art.read = true
                articlesLiveData.value = allArticles
            }
        }
        articleLocalRepository.updateArticle(article) {
            detailsIntent.putExtra(EXTRA_ARTICLE, article.articleId)
            context.startActivity(detailsIntent)
        }
    }

    fun onSortClicked(context: Context) {
        val sortIntent = Intent(context, ArticleSortingActivity::class.java)
        (context as Activity).startActivityForResult(sortIntent, 0)
    }

    fun sort(option: String?, read: Boolean?, unread: Boolean?) {
        var sortResult = mutableListOf<Article>()

        if (read == true)
            allArticles?.filterTo(sortResult) { article -> article.read }

        if (unread == true)
            allArticles?.filterTo(sortResult) { article -> !article.read }

        when (option) {
            "Author" -> sortResult.sortBy { it.author }
            "Title" -> sortResult.sortBy { it.title }
            "Date" -> sortResult.sortBy { it.date }
            "Website" -> sortResult.sortBy { it.website }
            else -> sortResult.sortBy { it.tags[0].label }
        }

        articlesLiveData.value = sortResult
    }

}
