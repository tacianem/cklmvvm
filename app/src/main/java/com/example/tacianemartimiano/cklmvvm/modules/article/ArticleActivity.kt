package com.example.tacianemartimiano.cklmvvm

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.tacianemartimiano.cklmvvm.models.Article
import com.example.tacianemartimiano.cklmvvm.modules.article.ArticleViewModel
import com.example.tacianemartimiano.cklmvvm.modules.base.BaseActivity
import com.example.tacianemartimiano.cklmvvm.utils.adapters.ArticleAdapter
import com.example.tacianemartimiano.cklmvvm.utils.listeners.ArticleListener
import kotlinx.android.synthetic.main.activity_article.*

class ArticleActivity : BaseActivity() {

    private var viewModel: ArticleViewModel? = null
    private var adapter: ArticleAdapter? = null

    private lateinit var articlesList: MutableList<Article>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)

        registerObservers()
        setupView()
        fetchArticles()

    }

    private fun setupView() {
        viewModel = ViewModelProviders.of(this).get(ArticleViewModel::class.java)

        adapter = ArticleAdapter(this, object : ArticleListener {
            override fun onArticleClicked(article: Article) {
                viewModel?.onArticleClicked(this@ArticleActivity, article)
            }

        })

        //TODO REMOVE MOCK

        val article = Article()//0)
        with(article) {
            articleId = 2
            title = "title"
            author = "author"
            date = "date"
            contents = "contents"
            website = "website"
            tag = "CKL"
            imageUrl = "http://www.ultimaficha.com.br/wp-content/uploads/2018/04/detetive-pikachu.jpg"
        }

        val article2 = Article()//1)
        with(article2) {
            articleId = 1
            title = "tit2le2"
            author = "au2thor2"
            date = "d2a2te"
            contents = "con2te2nts"
            website = "webs2it2e"
            tag = "CKL"
            imageUrl = "http://www.ultimaficha.com.br/wp-content/uploads/2018/04/detetive-pikachu.jpg"
        }

        articlesList = mutableListOf(article, article2)

        val layoutManager = LinearLayoutManager(this)
        articlesRecyclerView.layoutManager = layoutManager
        articlesRecyclerView.adapter = adapter

        viewModel?.fetchArticles(articlesList) //adapter list ir the return of fetch articles TODO
        adapter?.articlesList = articlesList
    }

    private fun fetchArticles() {
        //viewModel?.fetchArticles()
    }

    private fun registerObservers() {
        viewModel?.articlesListLiveData?.observe(this, Observer { articles ->
            articles?.let {
                adapter?.articlesList = it
            }
        })
    }

}
