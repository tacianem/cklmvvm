package com.example.tacianemartimiano.cklmvvm

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.tacianemartimiano.cklmvvm.model.entities.Article
import com.example.tacianemartimiano.cklmvvm.model.entities.Tag
import com.example.tacianemartimiano.cklmvvm.modules.article.ArticleViewModel
import com.example.tacianemartimiano.cklmvvm.utils.adapters.ArticleRecycleAdapter
import kotlinx.android.synthetic.main.activity_article.*

class ArticleActivity: AppCompatActivity() {

    private var adapter: ArticleRecycleAdapter? = null
    private var viewModel: ArticleViewModel? = null
    private var articles: List<Article> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)

        setupView()

        //listener pros itens + intent pra outra activity
        //realm (ou room) + retrofit
    }

    private fun setupView() { //TODO: is it always needed to put observers in here? how does it work?
        viewModel = ViewModelProviders.of(this).get(ArticleViewModel::class.java)

        val tag = Tag()
        tag.label = "CKL"

        val article = Article()
        article.title = "title"
        article.author = "author"
        article.date = "date"
        article.contents = "contents"
        article.website = "website"
        article.tags = listOf(tag)
        article.imageUrl = "http://www.ultimaficha.com.br/wp-content/uploads/2018/04/detetive-pikachu.jpg" //TODO: where are stored urls?

        articles = listOf(article)

        adapter = ArticleRecycleAdapter(this, articles)
        articlesRecyclerView.adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        articlesRecyclerView.layoutManager = layoutManager
    }

}
