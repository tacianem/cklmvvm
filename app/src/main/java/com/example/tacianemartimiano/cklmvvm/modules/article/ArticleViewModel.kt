package com.example.tacianemartimiano.cklmvvm.modules.article

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.content.Intent
import com.example.tacianemartimiano.cklmvvm.model.entities.Article
import com.example.tacianemartimiano.cklmvvm.modules.article_details.ArticleDetailsActivity
import com.example.tacianemartimiano.cklmvvm.utils.constants.EXTRA_ARTICLE

class ArticleViewModel(application: Application): AndroidViewModel(application) {

    var articles = MutableLiveData<List<Article>>()

    fun onArticleClicked(context: Context, article: Article?) {
        val detailsIntent = Intent(context, ArticleDetailsActivity::class.java)
        detailsIntent.putExtra(EXTRA_ARTICLE, article)
        context.startActivity(detailsIntent)
    }
}
