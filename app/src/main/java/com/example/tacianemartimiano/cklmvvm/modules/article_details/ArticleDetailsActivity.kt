package com.example.tacianemartimiano.cklmvvm.modules.article_details

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.example.tacianemartimiano.cklmvvm.R
import com.example.tacianemartimiano.cklmvvm.modules.base.BaseActivity
import kotlinx.android.synthetic.main.activity_article_details.*

class ArticleDetailsActivity: BaseActivity() {

    private var viewModel: ArticleDetailsViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_details)

        setupView()
        registerObservers()
    }

    private fun setupView() {
        showBackButton()
        viewModel = ViewModelProviders.of(this).get(ArticleDetailsViewModel::class.java)
        viewModel?.initWithExtras(intent.extras)
    }

    private fun registerObservers() {
        viewModel?.article?.observe(this, Observer { article ->
            article?.let {
                article_title.text = article.title
                author.text = article.author
                date.text = article.date
                website.text = article.website
                contents.text = article.contents
                author.text = article.author
                tag.text = article.tags?.get(0)?.label

                article.read = true
            }
        })
    }

}


