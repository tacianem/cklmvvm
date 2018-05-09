package com.example.tacianemartimiano.cklmvvm.modules.article_details

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.os.Bundle
import com.example.tacianemartimiano.cklmvvm.model.entities.Article
import com.example.tacianemartimiano.cklmvvm.utils.constants.EXTRA_ARTICLE

class ArticleDetailsViewModel(application: Application): AndroidViewModel(application) {

    var article = MutableLiveData<Article>()

    fun initWithExtras(extras: Bundle?){
        article.value = extras?.getParcelable(EXTRA_ARTICLE)
    }



}