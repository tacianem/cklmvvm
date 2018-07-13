package com.example.tacianemartimiano.cklmvvm.modules.articledetails

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.os.Bundle
import android.util.Log
import com.example.tacianemartimiano.cklmvvm.models.Article
import com.example.tacianemartimiano.cklmvvm.utils.constants.ERROR_DETAILS
import com.example.tacianemartimiano.cklmvvm.utils.constants.EXTRA_ARTICLE
import com.example.tacianemartimiano.cklmvvm.utils.repositories.local.ArticleRepository
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch

class ArticleDetailsViewModel(application: Application) : AndroidViewModel(application) {

    var articleLiveData: MutableLiveData<Article> = MutableLiveData()
    private var articlesRepository: ArticleRepository = ArticleRepository(getApplication())

    fun initWithExtras(extras: Bundle?) {
        getArticle(extras?.getInt(EXTRA_ARTICLE))
    }

    private fun getArticle(articleId: Int?) {
        launch {
            async {
                try {

                    articleId?.let { id ->
                        val article = articlesRepository.getArticle(id)
                        articleLiveData.postValue(article)
                    }
                } catch (e: Exception) {
                    Log.e(ERROR_DETAILS, e.message)
                    return@async
                }
            }
        }
    }

}