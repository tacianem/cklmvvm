package com.example.tacianemartimiano.cklmvvm.modules.article

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.content.Context
import android.content.Intent
import com.example.tacianemartimiano.cklmvvm.models.Article
import com.example.tacianemartimiano.cklmvvm.modules.article_details.ArticleDetailsActivity
import com.example.tacianemartimiano.cklmvvm.utils.constants.EXTRA_ARTICLE
import com.example.tacianemartimiano.cklmvvm.utils.repositories.ArticleRepository

class ArticleViewModel(application: Application): AndroidViewModel(application) {

    //    var articlesListLiveData = MutableLiveData<MutableList<Article>>()
    private var articleRepository: ArticleRepository = ArticleRepository(getApplication())

    fun onArticleClicked(context: Context, article: Article) {
        val detailsIntent = Intent(context, ArticleDetailsActivity::class.java)
        detailsIntent.putExtra(EXTRA_ARTICLE, article?.articleId)
        context.startActivity(detailsIntent)
    }

    fun fetchArticles(articlesList: MutableList<Article>) { //) {
//        var articlesList = mutableListOf<Article>()
//        ArticlesApiRepositoy.fetchArticles() TODO
//                ?.subscribeOn(Schedulers.io())
//                ?.observeOn(AndroidSchedulers.mainThread())
//                ?.subscribe({
//
//                }, {
//
//                })

        for (article in articlesList) {
            articleRepository.insertArticle(article)
        }
        //articlesListLiveData.value = articlesList
    }

}
