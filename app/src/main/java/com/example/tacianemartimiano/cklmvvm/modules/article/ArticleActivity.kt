package com.example.tacianemartimiano.cklmvvm.modules.article

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.graphics.Color
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
import com.example.tacianemartimiano.cklmvvm.utils.constants.EXTRA_READ
import com.example.tacianemartimiano.cklmvvm.utils.constants.EXTRA_SORT
import com.example.tacianemartimiano.cklmvvm.utils.constants.EXTRA_UNREAD
import kotlinx.android.synthetic.main.activity_article.*


class ArticleActivity : BaseActivity() {

    private var viewModel: ArticleViewModel? = null
    private var adapter: ArticleAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)
        viewModel = ViewModelProviders.of(this).get(ArticleViewModel::class.java)

        swipeRefresh.setOnRefreshListener {
            viewModel?.fetchArticles()
            swipeRefresh.isRefreshing = false
        }

//        swipeRefresh.setOnRefreshListener(object : SwipeRefreshLayout.OnRefreshListener {
//            override fun onRefresh() {
//                viewModel?.fetchArticles()
//            }
//        })

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
            R.id.sort -> viewModel?.onSortClicked(this)
        }
        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                val option = data?.getStringExtra(EXTRA_SORT)
                val read = data?.getBooleanExtra(EXTRA_READ, true)
                val unread = data?.getBooleanExtra(EXTRA_UNREAD, true)
                viewModel?.sort(option, read, unread)
            }
        }
    }

    private fun checkInternetConnection() {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        if (networkInfo != null && networkInfo.isConnected) {
            registerObservers()
            setupView()
        } else {
            showSnackbar()
            loadingBar.visibility = View.GONE
            emptyView.visibility = View.VISIBLE

        }
    }

    private fun showSnackbar() {
        val snackbar = Snackbar.make(coordinatorLayout, R.string.no_connection, Snackbar.LENGTH_INDEFINITE)
                .setActionTextColor(Color.MAGENTA)
        snackbar.setAction("TRY AGAIN") {
            checkInternetConnection()
        }
        snackbar.show()
    }

    private fun registerObservers() {
        viewModel?.articlesLiveData?.observe(this, Observer { articles ->
            if (articles?.isEmpty() == true) {
                loadingBar.visibility = View.GONE
                recyclerView.visibility = View.GONE
                emptyView.visibility = View.VISIBLE

            } else {
                emptyView.visibility = View.GONE
                loadingBar.visibility = View.GONE
                recyclerView.visibility = View.VISIBLE
                articles?.let {
                    adapter?.articlesList = it
                }
            }
        })
    }

    private fun setupView() {
        adapter = ArticleAdapter(this) { viewModel?.onArticleClicked(this, it) }
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter

        viewModel?.fetchArticles()
    }

}
