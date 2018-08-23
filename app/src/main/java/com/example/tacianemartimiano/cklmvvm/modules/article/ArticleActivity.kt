package com.example.tacianemartimiano.cklmvvm.modules.article

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.tacianemartimiano.cklmvvm.R
import com.example.tacianemartimiano.cklmvvm.modules.base.BaseActivity
import com.example.tacianemartimiano.cklmvvm.utils.adapters.ArticleAdapter
import kotlinx.android.synthetic.main.activity_article.*

class ArticleActivity : BaseActivity() {

    private var viewModel: ArticleViewModel? = null
    private var adapter: ArticleAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)

        setupView()
    }

    private fun setupView() {
        viewModel = ViewModelProviders.of(this).get(ArticleViewModel::class.java)
        registerObservers()

        adapter = ArticleAdapter(this) { viewModel?.onArticleClicked(this@ArticleActivity, it) }

        val layoutManager = LinearLayoutManager(this)
        articlesRecyclerView.layoutManager = layoutManager
        articlesRecyclerView.adapter = adapter

        viewModel?.fetchArticles()
        //viewModel?.clearTables()
    }

    private fun registerObservers() {
        viewModel?.articlesLiveData?.observe(this, Observer { articles ->
            articles?.let {
                adapter?.articlesList = it
            }
        })
    }

}
