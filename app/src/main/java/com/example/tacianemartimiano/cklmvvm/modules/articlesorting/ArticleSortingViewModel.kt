package com.example.tacianemartimiano.cklmvvm.modules.articlesorting

import android.app.Activity
import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.content.Context
import android.content.Intent
import com.example.tacianemartimiano.cklmvvm.modules.article.ArticleActivity
import com.example.tacianemartimiano.cklmvvm.utils.constants.EXTRA_SORT

class ArticleSortingViewModel(application: Application) : AndroidViewModel(application) {

    fun onSortClicked(context: Context, text: CharSequence) {
        val intent = Intent(context, ArticleActivity::class.java)
        intent.putExtra(EXTRA_SORT, text)
        (context as Activity).setResult(Activity.RESULT_OK, intent)
        context.finish()
    }
}