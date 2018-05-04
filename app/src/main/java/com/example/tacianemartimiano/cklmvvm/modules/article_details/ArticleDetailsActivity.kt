package com.example.tacianemartimiano.cklmvvm.modules.article_details

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.tacianemartimiano.cklmvvm.R
import kotlinx.android.synthetic.main.activity_article_details.*

class ArticleDetailsActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_details)
        setSupportActionBar(toolbar)

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /*val currentArticle: Article = intent.getSerializableExtra(EXTRA_ARTICLE)
        title.text = currentArticle.title
        author.text = currentArticle.author
        date.text = currentArticle.date
        website.text = currentArticle.website
        //content.text = currentArticle.content
        author.text = currentArticle.author*/

    }
}


