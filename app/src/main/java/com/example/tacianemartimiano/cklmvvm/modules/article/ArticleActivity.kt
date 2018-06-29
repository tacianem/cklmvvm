package com.example.tacianemartimiano.cklmvvm

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.tacianemartimiano.cklmvvm.model.entities.Tag
import com.example.tacianemartimiano.cklmvvm.models.Article
import com.example.tacianemartimiano.cklmvvm.modules.article.ArticleViewModel
import com.example.tacianemartimiano.cklmvvm.modules.base.BaseActivity
import com.example.tacianemartimiano.cklmvvm.utils.adapters.ArticleAdapter
import com.example.tacianemartimiano.cklmvvm.utils.listeners.ArticleListener
import kotlinx.android.synthetic.main.activity_article.*

class ArticleActivity: BaseActivity() {

    private var viewModel: ArticleViewModel? = null
    private var adapter: ArticleAdapter? = null

    private lateinit var articlesList: MutableList<Article>

    //region Lifecycle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)

        setupView()
        fetchArticles()
        registerObservers()
    }

    //endregion

    //region Private

    private fun setupView() {
        viewModel = ViewModelProviders.of(this).get(ArticleViewModel::class.java)

        adapter = ArticleAdapter(this, object: ArticleListener {
            override fun onArticleClicked(article: Article) {
                viewModel?.onArticleClicked(this@ArticleActivity, article)
            }
        })
        articlesRecyclerView.adapter = adapter

        //TODO REMOVE MOCK
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

        articlesList = mutableListOf(article, article, article, article, article, article, article, article, article, article)
        adapter?.articlesList = articlesList

        val layoutManager = LinearLayoutManager(this)
        articlesRecyclerView.layoutManager = layoutManager

        viewModel?.fetchArticles(articlesList)
    }

    private fun fetchArticles() {
        //viewModel?.fetchArticles()
    }

    private fun registerObservers() {
//        viewModel?.articlesListLiveData?.observe(this, Observer { articles ->
//            articles?.let {
//                adapter?.articlesList = it
//                adapter?.notifyDataSetChanged()
//            }
//        })
    }

    //endregion

}
