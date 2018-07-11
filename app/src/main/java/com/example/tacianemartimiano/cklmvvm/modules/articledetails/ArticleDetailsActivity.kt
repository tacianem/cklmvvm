package com.example.tacianemartimiano.cklmvvm.modules.articledetails

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.example.tacianemartimiano.cklmvvm.R
import com.example.tacianemartimiano.cklmvvm.modules.base.BaseActivity
import com.example.tacianemartimiano.cklmvvm.utils.glide.GlideApp
import kotlinx.android.synthetic.main.activity_article_details.*

class ArticleDetailsActivity : BaseActivity() {

    private var viewModel: ArticleDetailsViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_details)
        viewModel = ViewModelProviders.of(this).get(ArticleDetailsViewModel::class.java)

        registerObservers()
        setupView()
    }

    private fun setupView() {
        showBackButton()
        viewModel?.initWithExtras(intent.extras)
    }

    private fun registerObservers() {
        viewModel?.articleLiveData?.observe(this, Observer { article ->
            article?.let {
                article_title.text = article.title
                author.text = article.author
                date.text = article.date
                website.text = article.website
                contents.text = article.contents
                tag.text = article.tag

                GlideApp.with(this)
                        .load(article.imageUrl)
                        .into(article_image)
            }
        })
    }

}


