package com.example.tacianemartimiano.cklmvvm.modules.article

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.content.Context
import android.content.Intent
import com.example.tacianemartimiano.cklmvvm.model.entities.Article
import com.example.tacianemartimiano.cklmvvm.model.repositories.ArticleLocalRepository
import com.example.tacianemartimiano.cklmvvm.modules.article_details.ArticleDetailsActivity
import com.example.tacianemartimiano.cklmvvm.utils.constants.EXTRA_ARTICLE
import com.example.tacianemartimiano.cklmvvm.utils.database.AppDatabase
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class ArticleViewModel(application: Application): AndroidViewModel(application) {

    var articles: LiveData<List<Article.ArticleTag>>
    private var articlesRepository: ArticleLocalRepository

    init {
        val database = AppDatabase.getDatabase(application).articleDao()
        articlesRepository = ArticleLocalRepository(database)
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

    override fun fetchUser() {
        ApiDataManager.fetchUserObservable()
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe({
                    SessionHelper.instance.saveUserPremiumStatus(it.isPremium)
                    SessionHelper.instance.saveUserName(it.username)
                    it.planRecipeExpirationDate?.let { SessionHelper.instance.savePlanReceiptExpirationTime(it) }
                    SessionHelper.instance.saveUserId(it.id)
                    output?.onFetchUserSuccess()
                },{
                    output?.onFetchUserFail()
                })
    }

}
