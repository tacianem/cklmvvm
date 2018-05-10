package com.example.tacianemartimiano.cklmvvm

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.tacianemartimiano.cklmvvm.model.entities.Article
import com.example.tacianemartimiano.cklmvvm.model.entities.Tag
import com.example.tacianemartimiano.cklmvvm.modules.article.ArticleViewModel
import com.example.tacianemartimiano.cklmvvm.modules.base.BaseActivity
import com.example.tacianemartimiano.cklmvvm.utils.adapters.ArticleRecycleAdapter
import com.example.tacianemartimiano.cklmvvm.utils.listeners.ArticleListener
import kotlinx.android.synthetic.main.activity_article.*


class ArticleActivity: BaseActivity(), ArticleListener {

    private var adapter: ArticleRecycleAdapter? = null
    private var viewModel: ArticleViewModel? = null
    private var articles: List<Article> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)

        setupView()
        registerObservers()

        //RETROFIT + room
    }

    private fun setupView() {
        viewModel = ViewModelProviders.of(this).get(ArticleViewModel::class.java)
//-------------------
        val tag = Tag()
        tag.label = "CKL"

        val article = Article()
        article.title = "title"
        article.author = "author"
        article.date = "date"
        article.contents = "contents"
        article.website = "website"
        article.tags = listOf(tag)
        article.imageUrl = "http://www.ultimaficha.com.br/wp-content/uploads/2018/04/detetive-pikachu.jpg"

        articles = listOf(article, article, article, article, article, article, article, article, article, article)
//--------------------

        adapter = ArticleRecycleAdapter(this, this)
        articlesRecyclerView.adapter = adapter

    //--------
        adapter?.articlesList = articles
    //--------

        val layoutManager = LinearLayoutManager(this)
        articlesRecyclerView.layoutManager = layoutManager

        viewModel?.fetchArticlesFromAPI(articles)
        }

    override fun onArticleClicked(article: Article?) {
        viewModel?.onArticleClicked(this, article)
    }

    private fun registerObservers() {
        viewModel?.articles?.observe(this, Observer {
            //adapter?.articlesList = articles
            //adapter?.notifyDataSetChanged()
        })
    }

}
