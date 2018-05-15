package com.example.tacianemartimiano.cklmvvm.modules.article

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.content.Intent
import com.example.tacianemartimiano.cklmvvm.model.entities.Article
import com.example.tacianemartimiano.cklmvvm.model.repositories.ArticleLocalRepository
import com.example.tacianemartimiano.cklmvvm.modules.article_details.ArticleDetailsActivity
import com.example.tacianemartimiano.cklmvvm.utils.api.ArticlesApiRespositoy
import com.example.tacianemartimiano.cklmvvm.utils.constants.EXTRA_ARTICLE
import com.example.tacianemartimiano.cklmvvm.utils.database.AppDatabase
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class ArticleViewModel(application: Application): AndroidViewModel(application) {

    var articles: LiveData<List<Article>> = MutableLiveData<List<Article>>()
    var articlesTag: LiveData<List<Article.ArticleTag>>
    private var articlesLocalRep: ArticleLocalRepository

    init {
        val database = AppDatabase.getDatabase(application).articleDao()
        articlesLocalRep = ArticleLocalRepository(database)
        articlesTag = articlesLocalRep.allArticles()

    }


    fun onArticleClicked(context: Context, article: Article?) {
        val detailsIntent = Intent(context, ArticleDetailsActivity::class.java)
        detailsIntent.putExtra(EXTRA_ARTICLE, article?.id)
        context.startActivity(detailsIntent)
    }

    fun fetchArticles() {
        ArticlesApiRespositoy.fetchArticles()
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe({
                    articles.value = it
                }, {

                })
    }

}
