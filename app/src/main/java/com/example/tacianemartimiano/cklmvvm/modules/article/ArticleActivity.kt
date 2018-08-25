package com.example.tacianemartimiano.cklmvvm.modules.article

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.example.tacianemartimiano.cklmvvm.R
import com.example.tacianemartimiano.cklmvvm.modules.base.BaseActivity
import com.example.tacianemartimiano.cklmvvm.utils.adapters.ArticleAdapter
import kotlinx.android.synthetic.main.activity_article.*


class ArticleActivity : BaseActivity() {

    private var viewModel = ViewModelProviders.of(this).get(ArticleViewModel::class.java)
    private var adapter: ArticleAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)

        checkInternetConnection()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.dot_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        //Note: marking the menu item as showAsAction = always shows it directly on the actionBar
        val id = item?.itemId
        when (id) {
            R.id.sort -> viewModel.onSortClicked(this)
        }
        return true
    }

    private fun checkInternetConnection() {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        if (networkInfo != null && !networkInfo.isConnected) {//no internet
            Snackbar.make(frameLayout, "No internet connection!", Snackbar.LENGTH_INDEFINITE).show()
            progressBar.visibility = View.GONE


//            emptyListView.setText(R.string.no_connection);
//            articlesListView.setEmptyView(emptyListView);

        } else {
            registerObservers()
            setupView()
        }
    }

    private fun registerObservers() {
        viewModel.articlesLiveData.observe(this, Observer { articles ->
            articles?.let {
                adapter?.articlesList = it
            }
        })
    }

    private fun setupView() {
        adapter = ArticleAdapter(this) { viewModel.onArticleClicked(this, it) }

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter

        viewModel.fetchArticles()
    }

}
