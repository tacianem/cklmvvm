package com.example.tacianemartimiano.cklmvvm.modules.article

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.content.Context
import android.content.Intent
import com.example.tacianemartimiano.cklmvvm.models.Article
import com.example.tacianemartimiano.cklmvvm.modules.articledetails.ArticleDetailsActivity
import com.example.tacianemartimiano.cklmvvm.utils.constants.EXTRA_ARTICLE
import com.example.tacianemartimiano.cklmvvm.utils.repositories.local.ArticleRepository

class ArticleViewModel(application: Application) : AndroidViewModel(application) {

    var articlesListLiveData: LiveData<MutableList<Article>>? = null
    private var articleRepository: ArticleRepository = ArticleRepository(getApplication())

    fun fetchArticles(articlesList: List<Article>) { //) {
//        var articlesList = ArticleApiRepository.fetchArticles()
//                Observable<List?.subscribeOn(Schedulers.io())
//                ?.observeOn(AndroidSchedulers.mainThread())
//                ?.subscribe()

        for (article in articlesList) {
            articleRepository.insertArticle(article)
        }
        //articlesListLiveData.value = articlesList
    }

    fun onArticleClicked(context: Context, article: Article) {
        val detailsIntent = Intent(context, ArticleDetailsActivity::class.java)
        detailsIntent.putExtra(EXTRA_ARTICLE, article.articleId)
        article.read = true
        context.startActivity(detailsIntent)
    }

}
