package com.example.tacianemartimiano.cklmvvm.modules.articlesorting

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.tacianemartimiano.cklmvvm.R
import com.example.tacianemartimiano.cklmvvm.modules.base.BaseActivity

class ArticleSortingActivity : BaseActivity() {

    private var viewModel = ViewModelProviders.of(this).get(ArticleSortingViewModel::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.article_sorting)

        setupView()
    }

    private fun setupView() {
        showBackButton()
    }

    fun onClickSort(view: View) {
        viewModel.onSortClicked(this, (view as TextView).text)
    }

}