package com.example.tacianemartimiano.cklmvvm.modules.articlesorting

import android.app.Activity
import android.app.Activity.RESULT_OK
import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.content.Context
import android.content.Intent
import com.example.tacianemartimiano.cklmvvm.modules.article.ArticleActivity
import com.example.tacianemartimiano.cklmvvm.utils.constants.EXTRA_READ
import com.example.tacianemartimiano.cklmvvm.utils.constants.EXTRA_SORT
import com.example.tacianemartimiano.cklmvvm.utils.constants.EXTRA_UNREAD

class ArticleSortingViewModel(application: Application) : AndroidViewModel(application) {

    fun onSortClicked(context: Context, option: CharSequence, read: Boolean, unread: Boolean) {
        val intent = Intent(context, ArticleActivity::class.java)
        intent.putExtra(EXTRA_SORT, option)
        intent.putExtra(EXTRA_READ, read)
        intent.putExtra(EXTRA_UNREAD, unread)
        (context as Activity).setResult(RESULT_OK, intent)
        context.finish()
    }

}