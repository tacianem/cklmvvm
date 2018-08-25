package com.example.tacianemartimiano.cklmvvm.modules.articledetails

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.content.ContextCompat
import com.example.tacianemartimiano.cklmvvm.R
import com.example.tacianemartimiano.cklmvvm.modules.base.BaseActivity
import com.example.tacianemartimiano.cklmvvm.utils.glide.GlideApp
import kotlinx.android.synthetic.main.activity_article_details.*


class ArticleDetailsActivity : BaseActivity() {

    private var viewModel = ViewModelProviders.of(this).get(ArticleDetailsViewModel::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_details)

        registerObservers()
        setupView()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        viewModel.onBackPressed(this)
    }

    private fun registerObservers() {
        viewModel.articleLiveData.observe(this, Observer { article ->
            article?.let {
                articleTitle.text = article.title
                author.text = article.author
                date.text = article.date
                website.text = article.website
                contents.text = article.contents
                val label = article.tags[0].label
                tag.text = label

                tag.background = when (label.toLowerCase()) {
                    "science" -> ContextCompat.getDrawable(this, R.color.science)
                    "sports" -> ContextCompat.getDrawable(this, R.color.sports)
                    "politics" -> ContextCompat.getDrawable(this, R.color.politics)
                    else -> ContextCompat.getDrawable(this, R.color.tech)
                }

                GlideApp.with(this)
                        .load(article.imageUrl)
                        .into(articleImage)
            }
        })
    }

    private fun setupView() {
        showBackButton()
        viewModel.initWithExtras(intent.extras)
    }

}


