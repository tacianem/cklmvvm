package com.example.tacianemartimiano.cklmvvm.modules.article

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.content.Context
import android.content.Intent
import com.example.tacianemartimiano.cklmvvm.model.entities.Article
import com.example.tacianemartimiano.cklmvvm.model.repositories.ArticleRepository
import com.example.tacianemartimiano.cklmvvm.models.entities.ArticleTag
import com.example.tacianemartimiano.cklmvvm.modules.article_details.ArticleDetailsActivity
import com.example.tacianemartimiano.cklmvvm.utils.constants.EXTRA_ARTICLE
import com.example.tacianemartimiano.cklmvvm.utils.database.AppDatabase

class ArticleViewModel(application: Application): AndroidViewModel(application) {

    var articles: LiveData<List<ArticleTag>>
    private var articlesRepository: ArticleRepository

    init {
        val database = AppDatabase.getDatabase(application).articleDao()
        articlesRepository = ArticleRepository(database)
        articles = articlesRepository.allArticles()
    }


    fun onArticleClicked(context: Context, article: Article?) {
        val detailsIntent = Intent(context, ArticleDetailsActivity::class.java)
        detailsIntent.putExtra(EXTRA_ARTICLE, article?.id)
        context.startActivity(detailsIntent)
    }

    fun fetchArticlesFromAPI(articles: List<Article>) {
        articlesRepository.insertArticles(articles) //TODO: SYNC, no params
    }

}
